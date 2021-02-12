package cn.xhu.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//登录拦截器
public class LoginInterceptor implements HandlerInterceptor {

    /*
    拦截前执行的方法
    如果返回的true 则放行
  */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //拦截规则
        //session存在直接放行
        HttpSession session=request.getSession();
        //存在session中的名字
        String userName=(String)session.getAttribute("userName");
        if (userName!=null){
            return true;
        }
        //不存在则跳转到登录页面
        response.sendRedirect("/login/page");
        return false;
    }
}
