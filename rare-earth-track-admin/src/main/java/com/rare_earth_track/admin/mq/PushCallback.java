package com.rare_earth_track.admin.mq;

import com.google.protobuf.InvalidProtocolBufferException;
import com.rare_earth_track.admin.mq.handler.DataHandler;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;


@Component
public class PushCallback implements MqttCallback {
    @Autowired
    DataHandler handler;
    private IMqttAsyncClient Client;
    private static final Logger logger = Logger.getLogger(PushCallback.class.getCanonicalName());
    private MqClient mqClient;
    private int reConnTimes = 0;

    @Autowired
    public PushCallback(MqClient client, DataHandler handler) {
        mqClient = client;
        this.handler = handler;
    }

    @Override
    public void connectionLost(Throwable cause) {
        logger.info("connect is losted,and try to reconnect,cause = " + cause.getMessage() );
        cause.printStackTrace();
        while(true){
            if(mqClient.reConnect()){
                break;
            }
            try {
                if(reConnTimes++ > 20){//前20次每秒重连一次
                    Thread.sleep(1000);
                }else{//超过20次后没10s重连一次
                    Thread.sleep(10000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws InvalidProtocolBufferException, ParseException {
        byte[] payload = message.getPayload();
        OnenetMq.Msg obj = OnenetMq.Msg.parseFrom(payload);
        long at = obj.getTimestamp();
        long msgid = obj.getMsgid();
        String body = new String(obj.getData().toByteArray());

        SimpleDateFormat slf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = slf.format(at);

        logger.info("time = " + time +
                ",msg id: " + msgid +
                ", body: " + body);
//        OkHttpUtil bean = SpringContext.getBean(OkHttpUtil.class);
//        bean.postData("A2,03,032022070506,NFXT,NdFeB,50g,Tong,20220706,012454,20.10,25,3,99.0%,99.99%,0.01%,0.12%");
        handler.parseDataTest(body);
//        handler.parseData(body);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        Client = token.getClient();
    }


}