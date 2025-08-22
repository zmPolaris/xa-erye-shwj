package cn.xa.eyre.framework.config;

import cn.xa.eyre.framework.license.LicenseCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ProjectName WebMvcConfig
 * @author Administrator
 * @version 1.0.0
 * @Description 注册拦截器
 * @createTime 2022/4/30 0030 21:11
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LicenseCheckInterceptor())
                .addPathPatterns("/test/**")
                .addPathPatterns("/convert/**")
                .addPathPatterns("/synchro/**")
                .addPathPatterns("/medrec/**");
    }
}
