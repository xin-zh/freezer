package cn.xhu.controller;

import cn.xhu.biz.service.MenuService;
import cn.xhu.common.utils.BeanUtils;
import cn.xhu.core.dto.ResponseDTO;
import cn.xhu.core.req.menu.ReqMenuVO;
import cn.xhu.core.req.menu.ReqPageQueryMenuVO;
import cn.xhu.core.resp.RespMenuVO;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *@author:zx
 *@create time:2021/2/16 15:04
 *@desciption:
 *
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private MenuService menuService;

    @ResponseBody
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public ResponseDTO getList(ReqPageQueryMenuVO pageQuery){
        PageInfo<RespMenuVO> pageInfo = menuService.queryPageMenus(pageQuery);
        if (BeanUtils.isNotEmpty(pageInfo)){
            return ResponseDTO.createSuccessResponse(pageInfo);
        }else {
            return ResponseDTO.createFailResponse("查询失败");
        }

    }

    @ResponseBody
    @RequestMapping(value = "saveMenu",method = RequestMethod.POST)
    public ResponseDTO saveMenu(@RequestBody ReqMenuVO menu){
        try {
            Long id = menuService.saveMenu(menu);
            return ResponseDTO.createSuccessResponse();
        }catch (Exception e){
            return ResponseDTO.createFailResponse("保存权限信息失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "getMenuInfo",method = RequestMethod.GET)
    public ResponseDTO getMenuInfo(@RequestParam("id") Long menuId){
        try {
            RespMenuVO respMenuVO = menuService.queryById(menuId);
            return ResponseDTO.createSuccessResponse(respMenuVO);
        }catch (Exception e){
            return ResponseDTO.createFailResponse("获取权限信息失败");
        }
    }

    public ResponseDTO deleteByMenuId(@RequestParam("id") Long menuId){
        try {
            menuService.deleteMenu(menuId);
            menuService.deleteRoleMenuByMenuId(menuId);
            return ResponseDTO.createSuccessResponse();
        }catch (Exception e){
            return ResponseDTO.createFailResponse("删除失败");
        }
    }
}
