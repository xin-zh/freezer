package cn.xhu.biz.service;

import cn.xhu.core.pojo.Menu;
import cn.xhu.core.req.menu.ReqMenuVO;
import cn.xhu.core.req.menu.ReqPageQueryMenuVO;
import cn.xhu.core.req.menu.SaveMenuReqVO;
import cn.xhu.core.req.role.ReqRoleMenuVO;
import cn.xhu.core.resp.RespMenuVO;
import cn.xhu.core.resp.RespRoleVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author:zx
 * @create time:2021/2/12 21:07
 * @desciption:
 */


public interface MenuService {
    /**
     * 根据id获取用户权限
     * @param id
     * @return
     * @
     */
    List<RespMenuVO> getPermissionByUser(Long id) ;
    /**
     * 根据条件查询菜单
     * @param req
     * @return
     */
    RespRoleVO queryMenuByExample(ReqMenuVO req) ;
    /**
     * 分页查询
     * @param req
     * @return
     * @
     */
    PageInfo<RespMenuVO> queryPageMenus(ReqPageQueryMenuVO req) ;

    /**
     * 保存菜单信息
     * @param req
     * @return
     * @
     */
    int saveMenu(SaveMenuReqVO req) ;

    /**
     * 删除菜单信息
     * @param id
     * @return
     * @
     */
    int deleteMenu(Long id) ;

    List<Menu> queryRoleMenus(ReqRoleMenuVO req);

}
