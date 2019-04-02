package link.lycreate.bluefatty.service;

import link.lycreate.bluefatty.utils.Demander;
import link.lycreate.bluefatty.utils.LoginResult;
import link.lycreate.bluefatty.utils.NetResult;
import link.lycreate.bluefatty.utils.Servant;
import org.springframework.web.multipart.MultipartFile;
import sun.nio.ch.Net;

import java.util.List;

/**
 * UserService
 *
 * @author LYcreate
 * @date 2019/3/3 22:29
 */
public interface UserService {
    /**
     * description
     * @author LYcreate
     * @date 2019/3/3 22:32
     * @param userId
     * @return java.lang.String
     */
    public String getToken(int userId);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/3 22:32
     * @param userId
     * @return java.lang.String
     */
    public String getUserName(int userId);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/21 18:41
     * @param code
     * @return link.lycreate.bluefatty.utils.NetResult
     */
    public LoginResult userLogin(String code);
    /**
     * description
     * 验证是否存在该token
     * @author LYcreate
     * @date 2019/3/22 10:04
     * @param token
     * @return boolean
     */
    public boolean verifyToken(String token);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/25 22:53
     * @param userName
    stuName
    stuId
    universityId
    token
     * @return link.lycreate.bluefatty.utils.NetResult
     */
    public NetResult verifyStuInfo(String userName,String stuName,String stuId,int universityId,String token);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/26 11:05
     * @param token
     * @return int
     */
    public int getUserIdByToken(String token);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/27 15:45
     * @param userId
    file
    location
    imgType
     * @return link.lycreate.bluefatty.utils.NetResult
     */
    public NetResult uploadImg(int userId, MultipartFile file, String location, String imgType,int pos);
    /**
     * description
     * @author LYcreate
     * @date 2019/4/1 23:37
     * @param orderId
     * @return java.util.List<link.lycreate.bluefatty.utils.Demander>
     */
    public List<Demander> getDmderByOrderId(int orderId);
    /**
     * description
     * @author LYcreate
     * @date 2019/4/2 2:04
     * @param orderId
     * @return java.util.List<link.lycreate.bluefatty.utils.Demander>
     */
    public List<Demander> getOneDmderByOrderId(int orderId);
    /**
     * description
     * @author LYcreate
     * @date 2019/4/2 2:42
     * @param orderId
     * @return java.util.List<link.lycreate.bluefatty.utils.Servant>
     */
    public List<Servant> getServantByOrderId(int orderId);
    /**
     * description
     * @author LYcreate
     * @date 2019/4/2 2:42
     * @param orderId
     * @return java.util.List<link.lycreate.bluefatty.utils.Servant>
     */
    public List<Servant> getOneServantByOrderId(int orderId);
    /**
     * description
     * @author LYcreate
     * @date 2019/4/2 4:00
     * @param orderId
     * @return java.util.List<link.lycreate.bluefatty.utils.Demander>
     */
    public List<Demander>getDemServantByOrderId(int orderId);
    /**
     * description
     * @author LYcreate
     * @date 2019/4/2 11:12
     * @param orderId
     * @return java.util.List<link.lycreate.bluefatty.utils.Servant>
     */
    public List<Servant> getSerDemanderByOrderId(int orderId);
}
