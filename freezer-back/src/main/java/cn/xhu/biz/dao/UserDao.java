package cn.xhu.biz.dao;

import cn.xhu.core.pojo.Role;
import cn.xhu.core.pojo.User;
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

    List<Role> queryRolesByUserName(String username);

    void insert(ReqUserVO reqUser);

    void delete(Long id);

    void update(ReqUserVO user);

    List<User> queryAllUsers(ReqPageQueryUserVO req);

    User queryByCondition(ReqUserVO reqUser);

    User queryById(Long id);

}
