package cn.xhu.core.config;

import cn.xhu.biz.service.MenuService;
import cn.xhu.biz.service.RoleService;
import cn.xhu.biz.service.UserService;
import cn.xhu.common.utils.BeanUtils;
import cn.xhu.common.utils.CollectionUtils;
import cn.xhu.common.utils.StringUtils;
import cn.xhu.core.pojo.Menu;
import cn.xhu.core.pojo.Role;
import cn.xhu.core.pojo.User;
import cn.xhu.core.req.LoginRequestVO;
import cn.xhu.core.req.role.ReqRoleMenuVO;
import cn.xhu.core.req.user.ReqUserRoleVO;
import cn.xhu.core.req.user.ReqUserVO;
import cn.xhu.core.resp.RespUserVO;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author:zx
 * @create time:2021/1/31
 * @desciption:
 */
public class UserRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private MenuService menuService;

    /**
     * 权限校验
     * @param principals
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo=null;
        String username = (String) principals.getPrimaryPrincipal();
        if (StringUtils.isEmpty(username)){
            return authorizationInfo;
        }
        LoginRequestVO requestVO=new LoginRequestVO();
        requestVO.setUserName(username);
        RespUserVO respUserVO = userService.queryUserByCondition(requestVO);
        if(BeanUtils.isNotEmpty(respUserVO)) {
            authorizationInfo = new SimpleAuthorizationInfo();
            //注意这里的setRoles和setStringPermissions需要的都是一个Set<String>类型参数
            Set<String> role = new HashSet<String>();
            ReqUserRoleVO req = new ReqUserRoleVO();
            if(respUserVO.getId()!=0) {
                req.setUserName(respUserVO.getUserName());
                List<Role> roles = null;
                roles = roleService.queryRolesByUser(req);
                if (CollectionUtils.isNotEmpty(roles)) {
                    for (Role r : roles) {
                        role.add(r.getRoleName());
                    }
                }
                authorizationInfo.setRoles(role);
                Set<String> permission = new HashSet<String>();
                ReqRoleMenuVO reqRoleMenuVO = new ReqRoleMenuVO();
                reqRoleMenuVO.setRoles(roles);
//                reqRoleMenuVO.setRoles(roles.stream().map(p -> p.getRoleName()).collect(Collectors.toList()));
                List<Menu> menus = menuService.queryRoleMenus(reqRoleMenuVO);
                if(CollectionUtils.isNotEmpty(menus)) {
                    for (Menu p : menus) {
                        permission.add(p.getUrl());
                    }
                }
                authorizationInfo.setStringPermissions(permission);
            }
        }
        return authorizationInfo;
    }

    /**
     * 身份校验
     * @param token
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal();
        LoginRequestVO requestVO=new LoginRequestVO();
        requestVO.setUserName(username);
        RespUserVO respUserVO = userService.queryUserByCondition(requestVO);
        if (BeanUtils.isEmpty(respUserVO)){
            throw new UnknownAccountException(); //没有找到账号
        }
        //交给AuthenticationRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                respUserVO.getUserName(), //用户名
                respUserVO.getPassword(), //密码
                getName() //realm name
        );

        return authenticationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
