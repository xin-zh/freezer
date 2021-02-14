import cn.xhu.biz.service.RoleService;
import cn.xhu.core.pojo.Role;
import cn.xhu.core.req.user.ReqUserRoleVO;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 *@author:zx
 *@create time:2021/2/14 19:13
 *@desciption:
 *
 */

public class TestRoleDB extends BaseTest {
    @Resource
    private RoleService roleService;
    @Test
    public void test(){
        ReqUserRoleVO requestVO=new ReqUserRoleVO();
        requestVO.setUserName("zs122401");
        List<Role> roles = roleService.queryRolesByUser(requestVO);

    }
}
