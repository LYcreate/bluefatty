package link.lycreate.bluefatty.controller;

import link.lycreate.bluefatty.utils.NetResult;
import link.lycreate.bluefatty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/3/3 22:46
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public @ResponseBody NetResult login(HttpServletRequest request){
        String code=request.getParameter("code");
        NetResult netResult;
        if (code==null){
            netResult=new NetResult(0,"code为空！");
        }
        else{
            netResult=userService.userLogin(code);
        }
        return netResult;
    }
}
