package cn.xhu.biz.service.impl;

import cn.xhu.biz.service.RoleService;
import cn.xhu.core.pojo.Role;
import cn.xhu.core.req.role.ReqPageQueryRoleVO;
import cn.xhu.core.req.role.ReqRoleVO;
import cn.xhu.core.req.role.SaveRoleReqVO;
import cn.xhu.core.req.user.ReqUserRoleVO;
import cn.xhu.core.resp.RespRoleVO;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:zx
 * @create time:2021/2/12 22:25
 * @desciption:
 */

@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public RespRoleVO queryRoleByExample(ReqRoleVO req) {
        return null;
    }

    @Override
    public PageInfo<RespRoleVO> queryPageRoles(ReqPageQueryRoleVO req) {
        return null;
    }

    @Override
    public int saveRole(SaveRoleReqVO req) {
        return 0;
    }

    @Override
    public int deleteRole(Long id) {
        return 0;
    }

    @Override
    public int deleteAllRoleMenus(Long id) {
        return 0;
    }

    @Override
    public List<Role> queryRolesByUser(ReqUserRoleVO req) {
        return null;
    }
}
