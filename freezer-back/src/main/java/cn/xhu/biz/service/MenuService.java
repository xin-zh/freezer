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
     * 根据id获取对应的权限
     * @param id
     * @return
     * @
     */
    RespMenuVO queryById(Long id);

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
    Long saveMenu(ReqMenuVO req) ;

    /**
     * 删除菜单信息
     * @param id
     * @return
     * @
     */
    void deleteMenu(Long id) ;

    /**
     * 查询角色对应的权限关联信息
     * @param req
     * @return
     */
    List<Menu> queryRoleMenus(ReqRoleMenuVO req);

}
