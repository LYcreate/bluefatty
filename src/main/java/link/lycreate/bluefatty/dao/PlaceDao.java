package link.lycreate.bluefatty.dao;

import link.lycreate.bluefatty.model.Place;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlaceDao {
    int deleteByPrimaryKey(Integer placeId);

    int insert(Place record);

    int insertSelective(Place record);

    Place selectByPrimaryKey(Integer placeId);

    int updateByPrimaryKeySelective(Place record);

    int updateByPrimaryKey(Place record);
}