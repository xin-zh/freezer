package cn.xhu.controller;

import cn.xhu.biz.service.UserService;
import cn.xhu.common.utils.BeanUtils;
import cn.xhu.common.utils.StringUtils;
import cn.xhu.core.dto.ResponseDTO;
import cn.xhu.core.pojo.User;
import cn.xhu.core.req.LoginRequestVO;
import cn.xhu.core.req.user.ReqUserVO;
import cn.xhu.core.resp.RespUserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author:zx
 * @create time:2021/2/13 12:02
 * @desciption:
 */

@Controller
@RequestMapping("/login")
public class LoginController {
    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    public ResponseDTO getLoginInfo(@RequestBody LoginRequestVO req){
        if (BeanUtils.isEmpty(req)|| StringUtils.isEmpty(req.getPassword())||StringUtils.isEmpty(req.getUserName())){
            return ResponseDTO.createFailResponse("用户名或密码为空");
        }
        try {
            RespUserVO respUserVO = userService.queryUserByCondition(req);
            //账号和密码正确，shiro验证登录
            if (BeanUtils.isNotEmpty(respUserVO)) {
                //基于shiro实现登录
                Subject subject = SecurityUtils.getSubject();
                //用户名和密码保存到token中
                AuthenticationToken token = new UsernamePasswordToken(req.getUserName(), req.getPassword());
                //如果正常登录,表示没有异常.登陆成功
                subject.login(token);
                //将登录是账号和密码保存到响应数据中
                return ResponseDTO.createSuccessResponse(respUserVO);
            }
        }catch (Exception e){
            return ResponseDTO.createFailResponse("用户不存在或账号密码错误");
        }
        return ResponseDTO.createSuccessResponse();

    }

    public static void main(String[] args){
        LoginRequestVO reqUserVO = new LoginRequestVO();
        reqUserVO.setUserName("zs122401");
        reqUserVO.setPassword("123456");
        LoginController controller=new LoginController();
        ResponseDTO responseDTO =controller.getLoginInfo(reqUserVO);
        System.out.println(((User)responseDTO.getData()));

    }
}
