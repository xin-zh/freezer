
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * User相关的测试类
 *
 * @auther TyCoding
 * @date 2018/7/19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-beans.xml"})
public class UserTest {

    @Resource
    private DataSource dataSource;
    //测试创建用户
    @Test
    public void testConnect(){
        System.out.println(dataSource);
    }

}
