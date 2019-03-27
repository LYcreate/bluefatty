package link.lycreate.bluefatty.service.impl;

import com.alibaba.fastjson.JSONObject;
import link.lycreate.bluefatty.utils.*;
import link.lycreate.bluefatty.service.UserService;
import link.lycreate.bluefatty.dao.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Map;
import java.util.logging.Logger;

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
    @Resource
    private TypeDao typeDao;
    @Resource
    private PlaceDao placeDao;
    @Resource
    private UniversityDao universityDao;
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
    public LoginResult userLogin(String code) {
        Map<String,Object> resultMap=WxLogin.getUserInfo(code);
        LoginResult loginResult;
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
            loginResult=new LoginResult(0,"系统繁忙，请稍后重试!",0);
            return loginResult;
        }else if(errcode!=rightErrcode){
            loginResult=new LoginResult(0,"code无效！",0);
            return loginResult;
        }else{
            String openId = (String) resultMap.get("openid");
            String seesionKey = (String) resultMap.get("session_key");
            String infoStr=openId+seesionKey;
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                String token=Base64.getEncoder().encodeToString(md5.digest(infoStr.getBytes("utf-8")));
                int userCount=userDao.countByOpenId(openId);
                Integer userId;
                System.out.println("userCount"+userCount);
                if (userCount==1){
                    userId=userDao.getUserIdByOpenId(openId);
                    userDao.updateToken(userId,token);
                }else if (userCount==0){
                    userDao.insertSimpleUser(openId,token);
                    userId=userDao.getUserIdByOpenId(openId);
                }else {
                    loginResult=new LoginResult(0,"系统错误！",0);
                    return loginResult;
                }
                int userStatus=userDao.selectUserStatus(userId);
                loginResult=new LoginResult(1,code,userStatus,userId);
                if (userStatus==1||userStatus==2||userStatus==3){
                    UserInfo userInfo=userDao.selectUserInfo(userId);
                    loginResult.setUserInfo(userInfo);
                }
                int universityId=1;
                if (userStatus==2||userStatus==3){
                    universityId=userDao.selectUniversityId(userId);
                }
                Map<String,Object>placeMap=placeDao.selectPlaceMap(universityId);
                JSONObject place=new JSONObject(placeMap);
                Map<String,Object>typeMap=typeDao.selectTypeMap();
                JSONObject type=new JSONObject(typeMap);
                Map<String,Object>universityMap=universityDao.selectUniversityMap();
                JSONObject university=new JSONObject(universityMap);
                System.out.println("已取出结果");
                System.out.println(place.toString());
                loginResult.setUniversityId(universityId);
                loginResult.setType(type);
                loginResult.setPlace(place);
                loginResult.setUniversity(university);
                System.out.println("已设置完成");
                return loginResult;
            }catch (Exception e){
                e.printStackTrace();
                loginResult=new LoginResult(0,"系统异常！",0);
                return loginResult;
            }
        }
    }

    @Override
    public boolean verifyToken(String token) {
        int tokenCount=userDao.countByToken(token);
        boolean verifyResult=tokenCount==1?true:false;
        return verifyResult;
    }

    @Override
    public NetResult verifyStuInfo(String userName, String stuName, String stuId, int universityId, String token) {
        int result=userDao.updateNewUser(userName,stuName,stuId,universityId,token);
        if (result==1){
            NetResult netResult=new NetResult(1,"已提交认证信息！");
            return netResult;
        }else {
            NetResult netResult=new NetResult(0,"提交认证信息失败！");
            return netResult;
        }
    }

    @Override
    public int getUserIdByToken(String token) {
        int userId=userDao.selectUserIdByToken(token);
        return userId;
    }
    @Override
    public NetResult uploadImg(int userId, MultipartFile file, String location, String imgType,int pos) {
        if (file.isEmpty() || file.getOriginalFilename().isEmpty()) {
            NetResult netResult = new NetResult(0, "图片为空！");
        }
        String contentType = file.getContentType();
        if (!contentType.contains("")) {
            NetResult netResult = new NetResult(0, "文件类型不符合要求！");
        }
        String root_fileName = file.getOriginalFilename();
        Logger logger = Logger.getLogger("ImgStuCard");
        //处理图片
        logger.info("上传图片:name={},type={}" + root_fileName + contentType);
        //获取路径
        String return_path = ImgUtils.getFilePath(userId);
        String filePath = location + return_path;
        logger.info("图片保存路径={}" + filePath);
        String file_name = null;
        file_name = ImgUtils.saveImg(file, filePath, userId,imgType);
        NetResult netResult = new NetResult(0, "未保存图片");
        if (file_name!=null) {
            String finalPath=return_path + File.separator + file_name;
            int imgResult=0;
            if (imgType.equals("userImg")){
                imgResult=userDao.updateUserImg(userId,filePath);
            }else {
                if (pos==0){
                    imgResult=userDao.updateStuCardA(userId,filePath);
                }else {
                    imgResult=userDao.updateStuCardB(userId,finalPath);
                }
            }
            if(imgResult==1){
                netResult.setCode(1);
                netResult.setDescription(finalPath);
            }
        }
        logger.info("返回值：{}" + netResult.toString());
        return netResult;
    }
}
