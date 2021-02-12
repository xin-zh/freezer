package cn.xhu.biz.service;

import cn.xhu.core.pojo.Role;
import cn.xhu.core.req.role.ReqPageQueryRoleVO;
import cn.xhu.core.req.role.ReqRoleVO;
import cn.xhu.core.req.role.SaveRoleReqVO;
import cn.xhu.core.req.user.ReqUserRoleVO;
import cn.xhu.core.resp.RespRoleVO;
import com.github.pagehelper.PageInfo;

import java.util.List;


/**
 * @author:zx
 * @create time:2021/2/12 20:57
 * @desciption:
 */


public interface RoleService {
    /**
     * 根据条件查询角色
     * @param req
     * @return
     */
    RespRoleVO queryRoleByExample(ReqRoleVO req) ;


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
    int saveRole(SaveRoleReqVO req) ;

    /**
     * 删除角色信息
     * @param id
     * @return
     * @
     */
    int deleteRole(Long id) ;

    /**
     * 删除与角色相关的所有菜单权限信息
     * @param id
     * @return
     * @
     */
    int deleteAllRoleMenus(Long id) ;

    List<Role> queryRolesByUser(ReqUserRoleVO req) ;

}