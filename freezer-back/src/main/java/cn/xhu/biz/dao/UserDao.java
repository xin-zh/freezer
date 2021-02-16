package cn.xhu.biz.dao;

import cn.xhu.core.pojo.Role;
import cn.xhu.core.pojo.User;
import cn.xhu.core.req.LoginRequestVO;
import cn.xhu.core.req.user.ReqPageQueryUserVO;
import cn.xhu.core.req.user.ReqUserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author:zx
 * @create time:2021/1/31
 * @desciption:
 */
public interface UserDao {

    /**
     * 根据用户名（员工账号）查询角色信息
     * @param userName
     * @return
     */
    List<Role> queryRolesByUserName(String userName);

    /**
     * 新增员工用户信息
     * @param reqUser
     * @return
     */
    Long insert(ReqUserVO reqUser);

    /**
     * 删除员工信息
     * @param id
     */
    void delete(Long id);

    /**
     * 根据员工ID删除员工对应的角色关联信息
     * @param id
     */
    void deleteUserRoleByUserId(Long id);

    /**
     * 修改员工信息
     * @param user
     * @return
     */
    Long update(ReqUserVO user);

    /**
     * 分页查询
     * @param req
     * @return
     */
    List<User> queryPageUsers(ReqPageQueryUserVO req);

    /**
     * 查询所有员工记录条数
     * @param req
     * @return
     */
    Integer queryAllUsers(ReqPageQueryUserVO req);

    /**
     * 登录时的查询操作
     * @param reqUser
     * @return
     */
    User queryByCondition(LoginRequestVO reqUser);

    /**
     * 根据ID查询员工信息
     * @param id
     * @return
     */
    User queryById(Long id);

    void insertUserRoleInfo(@Param("userId") Long userId,@Param("roleId")Long roleId);

}
