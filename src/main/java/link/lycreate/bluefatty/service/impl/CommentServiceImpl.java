package link.lycreate.bluefatty.service.impl;

import link.lycreate.bluefatty.dao.CommentDao;
import link.lycreate.bluefatty.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName CommentServiceImpl
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/4/1 23:28
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentDao commentDao;
    @Override
    public String getComment(int orderId) {
        String comment=commentDao.selectCommentByOrderId(orderId);
        return comment;
    }
}
