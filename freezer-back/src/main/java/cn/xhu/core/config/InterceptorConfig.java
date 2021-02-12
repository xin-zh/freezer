package cn.xhu.core.config;

import cn.xhu.common.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        registry.addInterceptor(new LoginInterceptor())
                //添加拦截规则
                    .addPathPatterns("/**")
                //定义放行规则
                    .excludePathPatterns("/login/page","/login/do");//登录页面
//                    .excludePathPatterns("/css/**","/js/**","/fonts/**","/images/**","/lib/**");
    }
}
