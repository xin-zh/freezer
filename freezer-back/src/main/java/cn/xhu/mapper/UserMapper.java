package cn.xhu.mapper;

import cn.xhu.entity.Permission;
import cn.xhu.entity.Role;
import cn.xhu.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author:zx
 * @create time:2021/1/31
 * @desciption:
 */
public interface UserMapper {

    void correlationRoles(@Param("userId") Long userId, @Param("roleId") Long roleId);

    void uncorrelationRoles(@Param("userId") Long userId, @Param("roleId") Long roleId);

    List<Role> findRoles(String username);

    List<Permission> findPermissions(String username);

    boolean exists(@Param("userId") Long userId, @Param("roleId") Long roleId);

    void create(User user);

    void delete(Long id);

    void update(User user);

    List<User> findAll();

    User findByName(String username);

    User findById(Long id);

    void deleteAllUserRoles(Long id);
}
