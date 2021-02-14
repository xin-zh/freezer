package cn.xhu.biz.dao;

import cn.xhu.core.pojo.Menu;
import cn.xhu.core.pojo.Role;
import cn.xhu.core.pojo.User;
import cn.xhu.core.req.role.ReqPageQueryRoleVO;
import cn.xhu.core.req.role.ReqRoleVO;
import cn.xhu.core.req.user.ReqPageQueryUserVO;
import cn.xhu.core.req.user.ReqUserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author:zx
 * @create time:2021/2/13 15:34
 * @desciption:
 */


public interface RoleDao {
    List<Menu> queryMenusByRoleId(@Param("id") Long id);

    Long insert(ReqRoleVO reqRole);

    Long delete(@Param("id") Long id);

    void deleteRoleMenuByRoleId(@Param("id") Long id);

    Long update(ReqRoleVO reqRole);

    List<Role> queryPageRoles(ReqPageQueryRoleVO req);

    Integer queryAllRoles(ReqPageQueryRoleVO req);

    Role queryById(@Param("id") Long id);

}
