import cn.xhu.biz.service.MenuService;
import cn.xhu.core.pojo.Menu;
import cn.xhu.core.pojo.Role;
import cn.xhu.core.req.role.ReqRoleMenuVO;
import cn.xhu.core.resp.RespMenuVO;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *@author:zx
 *@create time:2021/2/14 19:52
 *@desciption:
 *
 */

public class TestMenuDB extends BaseTest {
    @Resource
    private MenuService menuService;

    @Test
    public  void test(){
        ReqRoleMenuVO request=new ReqRoleMenuVO();
        request.setRoles(mockData());
        List<Menu> menus = menuService.queryRoleMenus(request);
    }

    /**
     * 测试converter
     */
    @Test
    public void test2(){
        RespMenuVO respMenuVO = menuService.queryById(1L);
        System.out.println(respMenuVO);
    }

    List<Role> mockData(){
        List<Role> list=new ArrayList<>();
        Role role=new Role();
        role.setId(1L);
        list.add(role);
        return list;
    }
}
