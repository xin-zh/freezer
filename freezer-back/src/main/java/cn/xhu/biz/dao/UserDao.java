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

    List<Role> queryRolesByUserName(String userName);

    Long insert(ReqUserVO reqUser);

    void delete(Long id);

    void deleteUserRoleByUserId(Long id);

    Long update(ReqUserVO user);

    List<User> queryPageUsers(ReqPageQueryUserVO req);

    Integer queryAllUsers(ReqPageQueryUserVO req);

    User queryByCondition(LoginRequestVO reqUser);

    User queryById(Long id);

}
