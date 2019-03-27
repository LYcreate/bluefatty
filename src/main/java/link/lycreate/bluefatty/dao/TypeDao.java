package link.lycreate.bluefatty.dao;

import link.lycreate.bluefatty.model.Type;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface TypeDao {
    int deleteByPrimaryKey(Integer typeId);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);
    @MapKey("uuid")
    Map<String,Object> selectTypeMap();
}