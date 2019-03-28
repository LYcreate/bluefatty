package link.lycreate.bluefatty.dao;

import link.lycreate.bluefatty.model.University;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface UniversityDao {
    int deleteByPrimaryKey(Integer universityId);

    int insert(University record);

    int insertSelective(University record);

    University selectByPrimaryKey(Integer universityId);

    int updateByPrimaryKeySelective(University record);

    int updateByPrimaryKey(University record);

    List<Map<String,Object>> selectUniversityMap();
}