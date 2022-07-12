package com.rare_earth_track.portal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

/**
 * @ClassName TransactionTest
 * @Description: 测试类
 * @Author 匡龙
 * @Date 2022/7/1 15:58
 * @Version V1.0
 */
@SpringBootTest(classes = RareEarthTrackPortalApplication.class)
public class TransactionTest {
    public Long tUserId = 1L;
    public String tRegisterMail = "huanghaohhoa@163.com";
    public String tPassword = "123456";
    public String tUsername = "test";
    public String tEmail = "haunghao@foxmail.com";
    public String tErrorPassword = "error";
    public String tErrorIdentifier = "error";
    @Autowired
    PlatformTransactionManager transactionManager;
    TransactionStatus transactionStatus;
    @BeforeEach
    public void setUp(){
        transactionStatus = transactionManager.getTransaction(new DefaultTransactionAttribute());
    }
    @AfterEach
    public void tearDown(){
        transactionManager.rollback(transactionStatus);
    }
}
