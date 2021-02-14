import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author:zx
 * @create time:2021/2/12 19:51
 * @desciption:基础测试类
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BaseTest {
    @Resource
    private DataSource dataSource;

    @Test
    public void test() throws SQLException {
        System.out.println(dataSource);
        System.out.println(dataSource.getConnection());
    }

//    @Test
//    public  void test2(){
//        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("ehcache.xml");
//        System.out.println(ac);
//    }

}
