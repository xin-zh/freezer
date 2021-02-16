package cn.xhu.biz.service;

import cn.xhu.core.pojo.Role;
import cn.xhu.core.req.role.ReqPageQueryRoleVO;
import cn.xhu.core.req.role.ReqRoleVO;
import cn.xhu.core.req.role.SaveRoleReqVO;
import cn.xhu.core.req.user.ReqUserRoleVO;
import cn.xhu.core.resp.RespRoleVO;
import com.github.pagehelper.PageInfo;

import java.sql.SQLException;
import java.util.List;


/**
 * @author:zx
 * @create time:2021/2/12 20:57
 * @desciption:
 */


public interface RoleService {
    /**
     * 分页查询
     * @param req
     * @return
     * @
     */
    PageInfo<RespRoleVO> queryPageRoles(ReqPageQueryRoleVO req) ;

    /**
     * 保存角色信息
     * @param req
     * @return
     * @
     */
    Long saveRole(ReqRoleVO req) ;

    /**
     * 删除角色信息
     * @param id
     * @return
     * @
     */
    void deleteRole(Long id) ;

    /**
     * 删除与角色相关的所有菜单权限信息
     * @param id
     * @return
     * @
     */
    void deleteAllRoleMenus(Long id) ;

    void saveRoleMenuInfo(Long roleId,List<Long> menuIds) throws SQLException;

    List<Role> queryRolesByUser(ReqUserRoleVO req) ;

    Role queryById(Long id);

}
