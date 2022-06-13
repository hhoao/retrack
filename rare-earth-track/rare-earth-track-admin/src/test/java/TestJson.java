import com.rare_earth_track.admin.RareEarthTrackAdminApplication;
import com.rare_earth_track.common.service.RedisService;
import com.rare_earth_track.mgb.model.RetUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author hhoa
 * @date 2022/5/31
 **/

@SpringBootTest(classes = RareEarthTrackAdminApplication.class)
public class TestJson {
    @Autowired
    RedisService redisService;

    @Test
    public void testUser(){
        redisService.set("testUser", new RetUser());
        System.out.println(redisService.get("testUser"));
    }
    @Test
    public void test(){
        redisService.set("person", new RetUserDetailsTest(new RetUser()));
        Object person = redisService.get("person");
        System.out.println(person);
    }
    @Test
    public void testStartWith(){
        String str = "AAAAA";
        System.out.println(str.startsWith("aaa"));
    }
}
