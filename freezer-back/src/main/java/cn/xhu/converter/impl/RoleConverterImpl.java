package cn.xhu.converter.impl;

import cn.xhu.converter.RoleConverter;
import cn.xhu.core.pojo.Role;
import cn.xhu.core.req.role.ReqRoleVO;
import cn.xhu.core.resp.RespMenuVO;
import cn.xhu.core.resp.RespRoleVO;
import cn.xhu.core.resp.RespUserVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *@author:zx
 *@create time:2021/2/14 19:17
 *@desciption:
 *
 */
@Service
public class RoleConverterImpl extends BaseConverter implements RoleConverter {
    @Override
    public Role v2d(RespRoleVO v) {
        Role target=new Role();
        return (Role) converter(v,target.getClass());
    }

    @Override public Role v2d(ReqRoleVO v) {
        Role target=new Role();
        return (Role) converter(v,target.getClass());
    }

    @Override public RespRoleVO d2v(Role d) {
        RespRoleVO target=new RespRoleVO();
        return (RespRoleVO) converter(d,target.getClass());
    }

    @Override public List<RespRoleVO> d2vs(List<Role> d) {
        RespRoleVO target=null;
        List<RespRoleVO> list=new ArrayList<>();
        for (Role role:d){
            target=new RespRoleVO();
            RespRoleVO respRoleVO = (RespRoleVO) converter(role, target.getClass());
            list.add(respRoleVO);
        }
        return list;
    }

    @Override public List<Role> v2ds(List<RespRoleVO> v) {
        Role target=null;
        List<Role> list=new ArrayList<>();
        for (RespRoleVO respRoleVO:v){
            target=new Role();
            Role role = (Role) converter(respRoleVO, target.getClass());
            list.add(role);
        }
        return list;
    }
}
