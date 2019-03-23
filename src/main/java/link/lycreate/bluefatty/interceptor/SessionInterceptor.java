package link.lycreate.bluefatty.interceptor;

import link.lycreate.bluefatty.service.UserService;
import org.apache.ibatis.plugin.Intercepts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName SessionInterceptor
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/3/22 9:32
 */
@Component
public class SessionInterceptor implements HandlerInterceptor {
    @Resource
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器");
        String url=request.getRequestURI();
        System.out.println(url);
        String token=request.getHeader("cookie");
        System.out.println("cookie:"+token);
        if (token==null){
            return false;
        }else {
            boolean verifyResult = userService.verifyToken(token);
            return verifyResult;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
