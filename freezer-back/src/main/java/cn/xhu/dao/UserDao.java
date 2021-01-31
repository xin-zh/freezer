package cn.xhu.dao;

import cn.xhu.entity.Permission;
import cn.xhu.entity.Role;
import cn.xhu.entity.User;

import java.util.List;

/**
 * @author:zx
 * @create time:2021/1/31
 * @desciption:
 */
public interface UserDao {

    void correlationRoles(Long userId, Long... roleIds);

    void uncorrelationRoles(Long userId, Long... roleIds);

    List<Role> findRoles(String username);

    List<Permission> findPermissions(String username);

    void create(User user);

    void delete(Long id);

    void update(User user);

    List<User> findAll();

    User findByName(String username);

    User findById(Long id);

    void deleteAllUserRoles(Long id);
}
