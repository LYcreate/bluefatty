package link.lycreate.bluefatty.controller;
import link.lycreate.bluefatty.utils.ImgUtils;
import link.lycreate.bluefatty.utils.LoginResult;
import link.lycreate.bluefatty.utils.NetResult;
import link.lycreate.bluefatty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

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
    @Value("${img.location}")
    private String location;
    @RequestMapping("/login")
    public @ResponseBody LoginResult login(HttpServletRequest request){
        String code=request.getParameter("code");
        LoginResult loginResult;
        if (code==null){
            loginResult=new LoginResult(0,"code为空！",0);
        }
        else{
            loginResult=userService.userLogin(code);
        }
        return loginResult;
    }

    @RequestMapping(value = "/verifyStuInfo",method = {RequestMethod.POST})
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
            NetResult netResult=userService.verifyStuInfo(userName,stuName,stuId,universityId,token);
            return netResult;
        }
    }

    @RequestMapping(value = "/uploadStuCardImg",method ={RequestMethod.POST})
    public @ResponseBody NetResult uploadStuCardImg(HttpServletRequest request) {
        String token = request.getHeader("token");
        int userId = userService.getUserIdByToken(token);
        String strPos = request.getParameter("position");
        int pos=Integer.parseInt(strPos);
        MultipartRequest multipartRequest = (MultipartRequest) request;
        MultipartFile file = multipartRequest.getFile("file");
        String imgType="stuImg"+pos;
        return userService.uploadImg(userId, file,location,imgType,pos);
    }

    @RequestMapping(value = "/uploadUserImg",method = {RequestMethod.POST})
    public @ResponseBody NetResult uploadUserImg(HttpServletRequest request){
        String token = request.getHeader("token");
        int userId = userService.getUserIdByToken(token);
        MultipartRequest multipartRequest = (MultipartRequest) request;
        MultipartFile file = multipartRequest.getFile("file");
        String imgType="userImg";
        return userService.uploadImg(userId, file,location,imgType,0);
    }
}
