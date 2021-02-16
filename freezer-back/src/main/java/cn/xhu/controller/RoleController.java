package cn.xhu.controller;

import cn.xhu.biz.service.MenuService;
import cn.xhu.biz.service.RoleService;
import cn.xhu.common.utils.BeanUtils;
import cn.xhu.core.dto.ResponseDTO;
import cn.xhu.core.pojo.Role;
import cn.xhu.core.req.menu.ReqPageQueryMenuVO;
import cn.xhu.core.req.role.ReqPageQueryRoleVO;
import cn.xhu.core.req.role.ReqRoleVO;
import cn.xhu.core.req.role.SaveRoleReqVO;
import cn.xhu.core.resp.RespRoleVO;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 *@author:zx
 *@create time:2021/2/16 14:38
 *@desciption:
 *
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleService roleService;


    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ResponseDTO getList(@RequestBody ReqPageQueryRoleVO pageQuery){
        PageInfo<RespRoleVO> pageInfo = roleService.queryPageRoles(pageQuery);
        if(BeanUtils.isNotEmpty(pageInfo)){
            return ResponseDTO.createSuccessResponse(pageInfo);
        }else{
            return ResponseDTO.createFailResponse("查询失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "getRoleInfo",method = RequestMethod.GET)
    public ResponseDTO getRoleInfo(@RequestParam Long id){
        if (id == null) {
            return ResponseDTO.createFailResponse("传的ID错误");
        }
        Role role = roleService.queryById(id);
        return ResponseDTO.createSuccessResponse(role);
    }

    @ResponseBody
    @RequestMapping(value = "saveRole",method = RequestMethod.POST)
    public ResponseDTO saveRole(@RequestBody SaveRoleReqVO role){
        ReqRoleVO reqRoleVO=null;
        try {
            reqRoleVO=new ReqRoleVO();
            BeanUtils.copyProperties(role,reqRoleVO);
            Long roleId = roleService.saveRole(reqRoleVO);
            roleService.saveRoleMenuInfo(roleId,role.getMenuIds());
            return ResponseDTO.createSuccessResponse();
        } catch (SQLException e) {
            return ResponseDTO.createFailResponse("保存角色信息失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public ResponseDTO deleteRoleInfo(@RequestParam("id") Long id){
        try {
            roleService.deleteRole(id);
            roleService.deleteAllRoleMenus(id);
            return ResponseDTO.createSuccessResponse();
        }catch (Exception e){
            return ResponseDTO.createFailResponse("删除角色信息失败");
        }
    }

}
