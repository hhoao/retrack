import com.rare_earth_track.admin.RareEarthTrackAdminApplication;
import com.rare_earth_track.mgb.mapper.RetMemberMapper;
import com.rare_earth_track.mgb.mapper.RetUserMapper;
import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.mgb.model.RetUserAuth;
import com.rare_earth_track.mgb.model.RetUserExample;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
public class TestSelective {
    @Autowired
    RetUserMapper userMapper;
    @Autowired
    RetMemberMapper memberMapper;
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

    @Test
    public void testUpdate(){
        RetUser user = new RetUser();
        user.setId(21L);
        user.setNickname("小鱼");
        userMapper.updateByPrimaryKeySelective(user);
        System.out.println(userMapper.selectByPrimaryKey(21L));
    }

    @Test
    public void testInsertUserAuth(){
        RetUserAuth userAuth = new RetUserAuth();
        userAuth.setUserId(2L);
    }

    @Test
    public void testInsert(){
        RetUser user = new RetUser();
        user.setId(999L);
        user.setRoleId(3L);
        userMapper.insert(user);
//        userMapper.insertSelective(user);
//        RetUser user1 = userMapper.selectByPrimaryKey(999L);
        RetUser user1 = userMapper.selectByPrimaryKey(user.getId());
        System.out.println(user1);
    }

    @Test
    public void testMemberInsert(){
    }

    @Test
    public void testInsertSelective(){
        RetUser user= new RetUser();
        user.setId(999L);
        userMapper.insertSelective(user);
        //生成的mapper会出错， 且就算插入也需要外键
    }
    @Test
    public void testDeleteByExample(){
        RetUserExample user = new RetUserExample();
        user.createCriteria().
                andAddressEqualTo("山西");
        userMapper.deleteByExample(user);
        //u需要外键
    }
}
