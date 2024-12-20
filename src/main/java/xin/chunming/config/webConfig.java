package xin.chunming.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xin.chunming.intecepter.intecepter;
@Configuration
public class webConfig implements WebMvcConfigurer {
    @Autowired
    private intecepter inte;
/*1*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(inte).excludePathPatterns("/user/login","/user/register");
    }
}
