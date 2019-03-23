package link.lycreate.bluefatty.service.impl;

import link.lycreate.bluefatty.utils.NetResult;
import link.lycreate.bluefatty.utils.WxLogin;
import link.lycreate.bluefatty.service.UserService;
import link.lycreate.bluefatty.dao.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Map;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/3/3 22:30
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Override
    public String getToken(int userId) {
        System.out.println("service");
        return userDao.getToken(userId);
    }

    @Override
    public String getUserName(int userId) {
        return userDao.getUserName(userId);
    }

    @Override
    public NetResult userLogin(String code) {
        Map<String,Object> resultMap=WxLogin.getUserInfo(code);
        NetResult netResult;
        int errcode=-2;
        int rightErrcode=errcode;
        try {
            errcode = (Integer) resultMap.get("errcode");
        }catch (Exception e){
            System.out.println("无errcode返回");
        }
        int count=3;
        while(count!=0&&errcode==-1){
            resultMap=WxLogin.getUserInfo(code);
            count--;
        }
        if(count==0){
            netResult=new NetResult(0,"系统繁忙，请稍后重试!");
            return netResult;
        }else if(errcode!=rightErrcode){
            netResult=new NetResult(0,"code无效！");
            return netResult;
        }else{
            String openId = (String) resultMap.get("openid");
            String seesionKey = (String) resultMap.get("session_key");
            String infoStr=openId+seesionKey;
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                String token=Base64.getEncoder().encodeToString(md5.digest(infoStr.getBytes("utf-8")));
                int userCount=userDao.countByOpenId(openId);
                if (userCount==1){
                    Integer userId=userDao.getUserIdByOpenId(openId);
                    userDao.updateToken(userId,token);
                }else{
                    userDao.insertSimpleUser(openId,token);
                }
                netResult=new NetResult(1,token);
                return netResult;
            }catch (Exception e){
                e.printStackTrace();
                netResult=new NetResult(0,"系统异常！");
                return netResult;
            }
        }
    }

    @Override
    public boolean verifyToken(String token) {
        int tokenCount=userDao.countByToken(token);
        boolean verifyResult=tokenCount==1?true:false;
        return verifyResult;
    }
}
