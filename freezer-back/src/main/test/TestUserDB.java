import cn.xhu.biz.service.UserService;
import cn.xhu.common.utils.BeanUtils;
import cn.xhu.core.req.LoginRequestVO;
import cn.xhu.core.req.user.ReqPageQueryUserVO;
import cn.xhu.core.req.user.ReqUserVO;
import cn.xhu.core.resp.RespUserVO;
import com.github.pagehelper.PageInfo;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author:zx
 * @create time:2021/2/12 22:49
 * @desciption:
 */


public class TestUserDB extends BaseTest {
    @Resource
    private UserService userService;
    @Test
    public void test(){
        LoginRequestVO req=new LoginRequestVO();
        req.setUserName("zs122401");
        RespUserVO respUserVO = userService.queryUserByCondition(req);
        System.out.println(BeanUtils.isNotEmpty(respUserVO));
    }

    @Test
    public void test2() throws Exception {
        userService.deleteUser(1L);
    }

    @Test
    public void test3(){
        ReqPageQueryUserVO query=new ReqPageQueryUserVO();
        query.setRealName("");
        query.setUserName("");
        query.setUserTel("");
        PageInfo<RespUserVO> pageInfo = userService.queryPageUsers(query);

    }


}
