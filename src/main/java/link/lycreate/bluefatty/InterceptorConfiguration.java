package link.lycreate.bluefatty;

import link.lycreate.bluefatty.interceptor.SessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName InterceptorConfig
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/3/22 10:59
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
    @Autowired
    private SessionInterceptor sessionInterceptor;
    private List<String> excludeUrlList=new ArrayList<>();
    {
        excludeUrlList.add("/login");
        excludeUrlList.add("/getDmdByKeyword");
        excludeUrlList.add("/getDmdByPrice");
        excludeUrlList.add("/getDmdByType");
        excludeUrlList.add("/getDmdByPlace");
        excludeUrlList.add("/getDmdByDeadline");
        excludeUrlList.add("/getAllDemands");
        excludeUrlList.add("/getDmdByDmdId");
        excludeUrlList.add("/getServiceByKeyword");
        excludeUrlList.add("/getServiceByPrice");
        excludeUrlList.add("/getAllServices");
        excludeUrlList.add("/getServiceByPlace");
        excludeUrlList.add("/getServiceByType");
        excludeUrlList.add("/getServiceByTime");
        excludeUrlList.add("/getServiceByServiceId");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**").excludePathPatterns(excludeUrlList);
    }
}
