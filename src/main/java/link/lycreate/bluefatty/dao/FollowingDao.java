package link.lycreate.bluefatty.dao;

import link.lycreate.bluefatty.model.Following;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FollowingDao {
    int deleteByPrimaryKey(Integer logId);

    int insert(Following record);

    int insertSelective(Following record);

    Following selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(Following record);

    int updateByPrimaryKey(Following record);
}