package cn.xhu.biz.service.impl;

import cn.xhu.biz.dao.MenuDao;
import cn.xhu.biz.dao.RoleDao;
import cn.xhu.biz.dao.UserDao;
import cn.xhu.biz.service.RoleService;
import cn.xhu.common.utils.CollectionUtils;
import cn.xhu.converter.RoleConverter;
import cn.xhu.core.pojo.Role;
import cn.xhu.core.req.role.ReqPageQueryRoleVO;
import cn.xhu.core.req.role.ReqRoleVO;
import cn.xhu.core.req.role.SaveRoleReqVO;
import cn.xhu.core.req.user.ReqUserRoleVO;
import cn.xhu.core.resp.RespRoleVO;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author:zx
 * @create time:2021/2/12 22:25
 * @desciption:
 */

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao       roleDao;
    @Resource
    private UserDao userDao;
    @Resource
    private RoleConverter roleConverter;

    @Override
    public PageInfo<RespRoleVO> queryPageRoles(ReqPageQueryRoleVO req) {
        PageInfo<RespRoleVO> pageInfo = null;
        try {
            List<Role> roles = roleDao.queryPageRoles(req);
            if (CollectionUtils.isNotEmpty(roles)) {
                pageInfo = new PageInfo<>();
                pageInfo.setList(roleConverter.d2vs(roles));
            }
        } catch (Exception e) {
            throw new SQLException("查询出错");
        } finally {
            return pageInfo;
        }
    }

    @Override
    public Long saveRole(ReqRoleVO req) {
        Long result = null;
        try {
            //新增
            if (req.getId() == null) {
                result = roleDao.insert(req);
            }
            //修改
            else {
                result = roleDao.update(req);
            }
        } catch (Exception e) {
            throw new SQLException("保存员工信息失败");
        } finally {
            return result;
        }
    }

    @Override
    public void deleteRole(Long id) {
        roleDao.delete(id);
    }

    @Override
    public void deleteAllRoleMenus(Long id) {
        roleDao.deleteRoleMenuByRoleId(id);
    }

    @Override public void saveRoleMenuInfo(Long roleId, List<Long> menuIds) throws SQLException {
        try {
            menuIds.stream().forEach(t -> roleDao.insertRoleMenuInfo(roleId, t));
        }catch (Exception e){
            throw new SQLException("添加角色权限信息失败");
        }
    }

    @Override
    public List<Role> queryRolesByUser(ReqUserRoleVO req) {
        return userDao.queryRolesByUserName(req.getUserName());
    }



    @Override
    public Role queryById(Long id) {
        return roleDao.queryById(id);
    }
}
