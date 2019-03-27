package link.lycreate.bluefatty.dao;

import link.lycreate.bluefatty.model.Place;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface PlaceDao {
    int deleteByPrimaryKey(Integer placeId);

    int insert(Place record);

    int insertSelective(Place record);

    Place selectByPrimaryKey(Integer placeId);

    int updateByPrimaryKeySelective(Place record);

    int updateByPrimaryKey(Place record);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/27 23:10
     * @param universityId
     * @return java.util.Map<java.lang.Integer,java.lang.Object>
     */
    @MapKey("uuid")
    Map<String,Object> selectPlaceMap(int universityId);
}