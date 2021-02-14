package cn.xhu.converter;

import cn.xhu.core.pojo.Role;
import cn.xhu.core.pojo.Role;
import cn.xhu.core.req.role.ReqRoleVO;
import cn.xhu.core.resp.RespRoleVO;
import cn.xhu.core.resp.RespRoleVO;

import java.util.List;

/**
 * @author:zx
 * @create time:2021/2/14 12:38
 * @desciption:
 */


public interface RoleConverter {
    Role v2d(RespRoleVO v);

    Role v2d(ReqRoleVO v);

    RespRoleVO d2v(Role d);

    List<RespRoleVO> d2vs(List<Role> d);

    List<Role> v2ds(List<RespRoleVO> v);
}
