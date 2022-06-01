import com.rare_earth_track.admin.RareEarthTrackAdminApplication;
import com.rare_earth_track.mgb.model.RetUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author hhoa
 * @date 2022/5/31
 **/

@SpringBootTest(classes = RareEarthTrackAdminApplication.class)
public class TestCopyProperties {
    @Test
    public void test(){
        RetUser user = new RetUser();
        user.setNickname("小笑容");
        RetUser copyUser = new RetUser();
        copyUser.setId(11L);
        BeanUtils.copyProperties(user, copyUser);
        System.out.println(copyUser);
        //表明null值会被copy, 不能偷懒
    }
}
