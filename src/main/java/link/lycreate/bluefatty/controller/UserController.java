package link.lycreate.bluefatty.controller;

import link.lycreate.bluefatty.utils.NetResult;
import link.lycreate.bluefatty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/signUp",method = {RequestMethod.POST})
    public @ResponseBody NetResult signUp(HttpServletRequest request){
        String userName=request.getParameter("userName");
        String stuName=request.getParameter("stuName");
        String strUniversityId=request.getParameter("universityId");
        int universityId=Integer.parseInt(strUniversityId);
        String stuId=request.getParameter("stuId");
        String token=request.getHeader("token");
        if (token==null){
            NetResult netResult=new NetResult(0,"用户未登录！");
            return netResult;
        }else {
            NetResult netResult=userService.signUp(userName,stuName,stuId,universityId,token);
            return netResult;
        }
    }

}
