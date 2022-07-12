package com.rare_earth_track.admin.mq;


import com.rare_earth_track.admin.mq.handler.DataHandler;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

@Component
public class MqClient {
    private MqttConnectOptions options  = new MqttConnectOptions();;
    private MqttClient client ;
    /**
     * 是否需要手动回复ack
     * */
    private boolean manualAcks = false;

    private String subTopic;

    @Autowired
    private DataHandler handler;

    private Environment env;
    private String userName;
    private String mqTopic;
    private String mqSub;
    private String accessKey;

    public MqClient(DataHandler messageHandler, Environment env) {
        this.handler = messageHandler;
        this.env = env;
        userName = env.getProperty("mq.userName");
        mqTopic = env.getProperty("mq.mqTopic");
        mqSub = env.getProperty("mq.mqSub");
        accessKey = env.getProperty("mq.accessKey");
    }

//    public boolean getManualAcks(){
//        return manualAcks;
//    }
//
//    public void messageArrivedComplete(MqttMessage msg){
//        try {
//            client.messageArrivedComplete(msg.getId(),msg.getQos());
//        } catch (MqttException e) {
//            System.out.println("send puback catch exception");
//            e.printStackTrace();
//        }
//    }
    public synchronized boolean connect(){

        //用户自定义合法的UTF-8字符串，可为空
        String clientID = "MoYU";
        String serverURI = "ssl://183.230.40.96:8883";
//        String userName = "MoYU"; //MQID
//
//        String mqTopic = "topic-test"; //mq topic
//        String mqSub = "test-sub"; // mq sub

        try {
            if(null == client) {
               client =  new MqttClient(serverURI, clientID, new MemoryPersistence());
            }
            //获取连接配置
            resetOptions();
            try {
                client.connect(options);
            } catch (MqttException e) {
                e.printStackTrace();
            }
            subTopic = String.format("$sys/pb/consume/%s/%s/%s", userName, mqTopic, mqSub);
            client.setCallback(new PushCallback(this, handler));

            try {
                //订阅 topic $sys/pb/consume/$MQ_ID/$TOPIC/$SUB ，QoS必须大于0，否则订阅失败
                client.subscribe(subTopic, 1);
                System.out.println("sub success");
                return true;
            } catch (MqttException e) {
                System.out.println("sub failed");
                e.printStackTrace();
            }
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private void resetOptions(){
//        String userName = "MoYU"; //MQID
//        String accessKey = "w5qhghBLH31SiichSQlmN416a1xctCs86Kvx6k61wSM="; //mq access_key

        String expirationTime = System.currentTimeMillis() / 1000 + 100 * 24 * 60 * 60 + "";
        //版本号，无需修改
        String version = "2018-10-31";
        //通过MQ实例名称访问MQ
        String resourceName = "mqs/" + userName;
        //签名方法，支持md5、sha1、sha256
        String signatureMethod = "md5";
        String password = null;
        try {
            //生成token
            password = Token.assembleToken(version, resourceName, expirationTime, signatureMethod, accessKey);
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        options.setCleanSession(true); //clean session 必须设置 true
        options.setUserName(userName);
        options.setPassword(password.toCharArray());
        options.setConnectionTimeout(20);
        options.setKeepAliveInterval(30);
        options.setMqttVersion(MqttConnectOptions.MQTT_VERSION_3_1_1);
        InputStream caCrtFile = null;
        try{
            caCrtFile = this.getClass().getResource("/mqca/certificate.pem").openStream();
        } catch (IOException e){
            e.printStackTrace();
            return;
        }

        try {
            options.setSocketFactory(SslUtil.getSocketFactory(caCrtFile));
        } catch (NoSuchAlgorithmException | KeyStoreException | CertificateException
                | IOException | KeyManagementException e) {
            e.printStackTrace();
        }
    }

    public boolean reConnect() {
        if(null != client) {
            try {
                if(!client.isConnected()){ //订阅失败而导致重连是不需要重新连接
                    resetOptions();//防止token过期，需重新设置
                    client.connect(options);
                }
                client.subscribe(subTopic, 1);//订阅失败会抛异常
                System.out.println("reconncet and sub ok");
                return true;
            } catch (Exception e) {//订阅和连接失败都会进到此异常中
                System.out.println("reconnect failed");
                e.printStackTrace();//由于在循环中调用，建议调试时打印堆栈信息，正式中此打印删除
                return false;
            }
        }else{
            return connect();
        }
    }

//    public static void main(String[] args) {
//        MqClient mqClient = new MqClient();
//        mqClient.connect();
//    }
}
