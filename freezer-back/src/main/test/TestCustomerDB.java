import cn.xhu.biz.service.CustomerService;
import cn.xhu.core.req.LoginRequestVO;
import cn.xhu.core.req.customer.ReqPageQueryCustomerVO;
import cn.xhu.core.resp.RespCustomerVO;
import com.github.pagehelper.PageInfo;
import org.junit.Test;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 *@author:zx
 *@create time:2021/2/20 21:53
 *@desciption:
 *
 */

public class TestCustomerDB extends BaseTest {
    @Resource
    private CustomerService customerService;

    @Test
    @Override
    public void test() throws SQLException {
        LoginRequestVO request=new LoginRequestVO();
        request.setUserName("czjl010901");
        request.setPassword("123456");
        RespCustomerVO respCustomerVO = customerService.queryCustomerByCondition(request);

    }

    @Test
    public void testPageQuery(){
        ReqPageQueryCustomerVO query=new ReqPageQueryCustomerVO();
        query.setRealName("");
        query.setCustomerName("");
        query.setCustomerTel("");
        PageInfo<RespCustomerVO> respCustomerVOPageInfo = customerService.queryPageCustomers(query);
    }
}
