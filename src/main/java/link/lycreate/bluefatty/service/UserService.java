package link.lycreate.bluefatty.service;

import link.lycreate.bluefatty.utils.NetResult;

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
    public NetResult userLogin(String code);
    /**
     * description
     * 验证是否存在该token
     * @author LYcreate
     * @date 2019/3/22 10:04
     * @param token
     * @return boolean
     */
    public boolean verifyToken(String token);
}
