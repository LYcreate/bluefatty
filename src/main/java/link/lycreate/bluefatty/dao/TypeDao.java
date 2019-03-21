package link.lycreate.bluefatty.dao;

import link.lycreate.bluefatty.model.Type;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TypeDao {
    int deleteByPrimaryKey(Integer typeId);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);
}