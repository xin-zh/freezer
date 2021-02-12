import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.xml.crypto.Data;

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
    public void test(){
        System.out.println(dataSource);
    }

}
