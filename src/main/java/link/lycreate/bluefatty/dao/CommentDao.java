package link.lycreate.bluefatty.dao;

import link.lycreate.bluefatty.model.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentDao {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);
}