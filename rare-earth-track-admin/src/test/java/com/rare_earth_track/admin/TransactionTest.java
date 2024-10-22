package com.rare_earth_track.admin;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

/**
 * @author hhoa
 * @date 2022/5/31
 **/

@SpringBootTest(classes = RareEarthTrackAdminApplication.class)
public abstract class TransactionTest {
    public Long tUserId = 1L;
    public String tRegisterMail = "huanghaohhoa@163.com";
    public String tUsername = "test";
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
