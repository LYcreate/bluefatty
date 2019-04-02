package link.lycreate.bluefatty.service;

import javax.annotation.Resource;

/**
 * CommentService
 *
 * @author LYcreate
 * @date 2019/4/1 23:25
 */
public interface CommentService {
    /**
     * description
     * @author LYcreate
     * @date 2019/4/1 23:27
     * @param orderId
     * @return java.lang.String
     */
    public String getComment(int orderId);
}
