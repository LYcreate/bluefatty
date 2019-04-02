package link.lycreate.bluefatty.dao;

import link.lycreate.bluefatty.model.User;
import link.lycreate.bluefatty.utils.Demander;
import link.lycreate.bluefatty.utils.Servant;
import link.lycreate.bluefatty.utils.StuInfo;
import link.lycreate.bluefatty.utils.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {
    /**
     * description
     * @author LYcreate
     * @date 2019/3/21 15:49
     * @param record
     * @return int
     */
    int insert(User record);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/21 15:49
     * @param record
     * @return int
     */
    int insertSelective(User record);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/21 15:49
     * @param userId
     * @return int
     */
    String getToken(int userId);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/21 16:19
     * @param userId
     * @return int
     */
    String getUserName(int userId);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/21 19:59
     * @param openId
     * @return int
     */
    int getUserIdByOpenId(String openId);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/22 0:10
     * @param userId
    token
     * @return int
     */
    int updateToken(@Param("userId") int userId, @Param("token") String token);
   /**
    * description
    * @author LYcreate
    * @date 2019/3/22 0:10
    * @param openId
   token
    * @return int
    */
    int insertSimpleUser(@Param("openId") String openId,@Param("token") String token);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/22 0:17
     * @param openId
     * @return int
     */
    int countByOpenId(String openId);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/22 10:07
     * @param token
     * @return int
     */
    int countByToken(String token);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/25 23:40
     * @param userName
    stuName
    stuId
    universityId
    token
     * @return int
     */
    int updateNewUser(@Param("userName")String userName,@Param("stuName")String stuName,@Param("stuId")String stuId,@Param("universityId")int universityId,@Param("token")String token);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/26 11:31
     * @param token
     * @return int
     */
    int selectUserIdByToken(String token);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/27 16:45
     * @param userId
    finalPath
     * @return int
     */
    int updateUserImg(@Param("userId") int userId,@Param("finalPath") String finalPath);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/27 16:46
     * @param userId
    finalPath
     * @return int
     */
    int updateStuCardA(@Param("userId") int userId,@Param("finalPath") String finalPath);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/27 16:46
     * @param userId
    finalPath
     * @return int
     */
    int updateStuCardB(@Param("userId") int userId,@Param("finalPath") String finalPath);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/27 20:29
     * @param userId
     * @return int
     */
    int selectUserStatus(int userId);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/27 23:34
     * @param userId
     * @return link.lycreate.bluefatty.utils.UserInfo
     */
    UserInfo selectUserInfo(int userId);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/27 23:34
     * @param userId
     * @return link.lycreate.bluefatty.utils.StuInfo
     */
    StuInfo selectStuInfo(int userId);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/27 23:56
     * @param userId
     * @return int
     */
    int selectUniversityId(int userId);
    /**
     * description
     * @author LYcreate
     * @date 2019/4/1 23:40
     * @param orderId
     * @return java.util.List<link.lycreate.bluefatty.utils.Demander>
     */
    List<Demander> selectDemanderByOrderId(int orderId);
    /**
     * description
     * @author LYcreate
     * @date 2019/4/2 2:06
     * @param orderId
     * @return java.util.List<link.lycreate.bluefatty.utils.Demander>
     */
    List<Demander> selectOneDemanderByOrderId(int orderId);

    List<Servant> selectServantByOrderId(int orderId);

    List<Servant> selectOneServantByOrderId(int orderId);

    List<Demander>selectDemServantByOrderId(int orderId);

    List<Servant> selectSerDemanderByOrderId(int orderId);
}