import cn.xhu.biz.service.UserService;
import cn.xhu.common.utils.BeanUtils;
import cn.xhu.core.req.user.ReqUserVO;
import cn.xhu.core.resp.RespUserVO;
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
        ReqUserVO req=new ReqUserVO();
        req.setUserName("zs122401");
        RespUserVO respUserVO = userService.queryUserByCondition(req);
        System.out.println(BeanUtils.isNotEmpty(respUserVO));
    }
}
