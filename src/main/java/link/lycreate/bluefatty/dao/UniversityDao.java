package link.lycreate.bluefatty.dao;

import link.lycreate.bluefatty.model.University;
import link.lycreate.bluefatty.utils.UniversityResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UniversityDao {
    int deleteByPrimaryKey(Integer universityId);

    int insert(University record);

    int insertSelective(University record);

    University selectByPrimaryKey(Integer universityId);

    int updateByPrimaryKeySelective(University record);

    int updateByPrimaryKey(University record);

    List<UniversityResult> selectAllUniversity();

}