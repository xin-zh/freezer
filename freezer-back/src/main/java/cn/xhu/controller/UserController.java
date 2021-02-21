package cn.xhu.controller;

import cn.xhu.biz.service.RoleService;
import cn.xhu.biz.service.UserService;
import cn.xhu.common.utils.BeanUtils;
import cn.xhu.core.dto.ResponseDTO;
import cn.xhu.core.pojo.User;
import cn.xhu.core.req.role.ReqPageQueryRoleVO;
import cn.xhu.core.req.user.ReqPageQueryUserVO;
import cn.xhu.core.req.user.ReqUserVO;
import cn.xhu.core.req.user.SaveUserReqVO;
import cn.xhu.core.resp.RespRoleVO;
import cn.xhu.core.resp.RespUserVO;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *@author:zx
 *@create time:2021/2/16 13:36
 *@desciption:
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ResponseDTO getList(@RequestBody ReqPageQueryUserVO pageQuery){
        PageInfo<RespUserVO> pageInfo = userService.queryPageUsers(pageQuery);
        if (BeanUtils.isNotEmpty(pageInfo)){
            return ResponseDTO.createSuccessResponse(pageInfo);
        }else{
            return ResponseDTO.createFailResponse("数据查询失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "saveUser",method = RequestMethod.POST)
    public ResponseDTO saveUser(SaveUserReqVO user){
        ReqUserVO reqUserVO=null;
        try {
            reqUserVO=new ReqUserVO();
            BeanUtils.copyProperties(user, reqUserVO);
            Long id = userService.saveUser(reqUserVO);
            userService.saveUserRoleInfo(id,user.getRoleIds());
        } catch (Exception e) {
            e.printStackTrace();
            ResponseDTO.createFailResponse("保存用户失败");
        }
        return ResponseDTO.createSuccessResponse();

    }


    @ResponseBody
    @RequestMapping(value = "getUserInfo",method = RequestMethod.GET)
    public ResponseDTO getUserInfo(@RequestParam Long id){
        try {
            User user = userService.queryById(id);
            return ResponseDTO.createSuccessResponse(user);
        }catch (Exception e){
            return ResponseDTO.createFailResponse("用户信息获取失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ResponseDTO deleteById(@RequestParam Long id){
        try {
            userService.deleteUser(id);
            userService.deleteAllUserRoles(id);
            return ResponseDTO.createSuccessResponse();
        } catch (Exception e) {

            e.printStackTrace();
            return ResponseDTO.createFailResponse("删除用户失败");
        }
    }
    @ResponseBody
    @RequestMapping(value = "initRole",method = RequestMethod.GET)
    public ResponseDTO initRole(){
        ReqPageQueryRoleVO query=new ReqPageQueryRoleVO();
        PageInfo<RespRoleVO> pageInfo = roleService.queryPageRoles(query);
        return ResponseDTO.createSuccessResponse(pageInfo.getList());
    }
}
