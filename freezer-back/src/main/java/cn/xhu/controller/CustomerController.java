package cn.xhu.controller;

import cn.xhu.biz.service.CustomerService;
import cn.xhu.core.dto.ResponseDTO;
import cn.xhu.core.req.LoginRequestVO;
import cn.xhu.core.resp.RespCustomerVO;
import cn.xhu.core.resp.RespUserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *@author:zx
 *@create time:2021/2/21 14:08
 *@desciption:
 *
 */
@Controller
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseDTO login(@RequestBody LoginRequestVO loginRequestVO){
        RespCustomerVO respCustomerVO = customerService.queryCustomerByCondition(loginRequestVO);
        if (respCustomerVO==null)
            return ResponseDTO.createFailResponse("用户名或密码错误");
        return ResponseDTO.createSuccessResponse(respCustomerVO);
    }
}
