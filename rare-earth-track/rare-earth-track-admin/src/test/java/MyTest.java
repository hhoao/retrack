import com.rare_earth_track.admin.RareEarthTrackAdminApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Date;

/**
 * @author hhoa
 * @date 2022/5/11
 **/
@SpringBootTest(classes = RareEarthTrackAdminApplication.class)
public class MyTest {
    @Autowired
    MailSender mailSender;
    @Test
    public void test(){
        System.out.println(new Date());
    }
    @Test
    public void testMail(){
        JavaMailSenderImpl javaMailSender =((JavaMailSenderImpl)mailSender);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("haunghao@foxmail.com");
        message.setTo("huanghaohhoa@163.com");
        message.setSubject("Spring Email Test");
        message.setText("helloworld");
        mailSender.send(message);
    }
}
