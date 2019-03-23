package link.lycreate.bluefatty.dao;

import link.lycreate.bluefatty.model.Order;
import link.lycreate.bluefatty.utils.DemandResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface OrderDao {
    /**
     * description
     * @author LYcreate
     * @date 2019/3/22 20:48
     * @param orderId
     * @return int
     */
    int deleteByPrimaryKey(Integer orderId);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/22 20:48
     * @param record
     * @return int
     */
    int insert(Order record);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/22 20:48
     * @param record
     * @return int
     */
    int insertSelective(Order record);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/22 20:48
     * @param orderId
     * @return link.lycreate.bluefatty.model.Order
     */
    Order selectByPrimaryKey(Integer orderId);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/22 20:48
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(Order record);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/22 20:48
     * @param record
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(Order record);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/22 20:49
     * @param record
     * @return int
     */
    int updateByPrimaryKey(Order record);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/22 20:49
     * @param pageNow
     * @return java.util.List<link.lycreate.bluefatty.model.Order>
     */
    List<DemandResult> selectDmdByPage(int pageNow);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/23 9:35
     * @param pageNow
    place
     * @return java.util.List<link.lycreate.bluefatty.utils.DemandResult>
     */
    List<DemandResult> selectDmdByPlace(@Param("pageNow") int pageNow,@Param("place") List<Integer> place);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/23 21:39
     * @param pageNow
    type
     * @return java.util.List<link.lycreate.bluefatty.utils.DemandResult>
     */
    List<DemandResult> selectDmdByType(@Param("pageNow") int pageNow,@Param("type")List<Integer> type);
   /**
    * description
    * @author LYcreate
    * @date 2019/3/23 16:40
    * @param pageNow
   lowDeadline
   highDeadline
    * @return java.util.List<link.lycreate.bluefatty.utils.DemandResult>
    */
    List<DemandResult> selectDmdByDeadline(@Param("pageNow") int pageNow, @Param("lowDeadline") Timestamp lowDeadline, @Param("highDeadline") Timestamp highDeadline);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/23 16:40
     * @param pageNow
    lowPrice
    highPrice
     * @return java.util.List<link.lycreate.bluefatty.utils.DemandResult>
     */
    List<DemandResult> selectDmdByPrice(@Param("pageNow") int pageNow,@Param("lowPrice")int lowPrice,@Param("highPrice")int highPrice);
}