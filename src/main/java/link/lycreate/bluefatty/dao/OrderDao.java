package link.lycreate.bluefatty.dao;

import link.lycreate.bluefatty.model.Order;
import link.lycreate.bluefatty.utils.DemandResult;
import link.lycreate.bluefatty.utils.ServiceResult;
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
     * @date 2019/3/26 21:56
     * @param pageNow
    universityId
    place
    lowDeadline
    highDeadline
    lowPrice
    highPrice
    type
    keyword
     * @return java.util.List<link.lycreate.bluefatty.utils.DemandResult>
     */
    List<DemandResult> selectDmdByPage(@Param("pageNow")int pageNow, @Param("universityId")int universityId,
                                       @Param("place") List<Integer> place, @Param("lowDeadline")Timestamp lowDeadline,
                                       @Param("highDeadline")Timestamp highDeadline, @Param("lowPrice")int lowPrice,
                                       @Param("highPrice")int highPrice, @Param("type")List<Integer> type);
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
    /**
     * description
     * @author LYcreate
     * @date 2019/3/24 17:36
     * @param pageNow
    keyword
     * @return java.util.List<link.lycreate.bluefatty.utils.DemandResult>
     */
    List<DemandResult> selectDmdByKeyword(@Param("pageNow")int pageNow,@Param("keyword")String keyword);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/25 18:44
     * @param dmdId
     * @return java.lang.String
     */
    String selectDmdByDmdId(int dmdId);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/26 21:57
     * @param pageNow
    universityId
    place
    lowDeadline
    highDeadline
    lowPrice
    highPrice
    type
    keyword
     * @return java.util.List<link.lycreate.bluefatty.utils.ServiceResult>
     */
    List<ServiceResult> selectServiceByPage(@Param("pageNow")int pageNow, @Param("universityId")int universityId,
                                       @Param("place") List<Integer> place, @Param("lowDeadline")Timestamp lowDeadline,
                                       @Param("highDeadline")Timestamp highDeadline, @Param("lowPrice")int lowPrice,
                                       @Param("highPrice")int highPrice, @Param("type")List<Integer> type);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/24 11:34
     * @param pageNow
    lowDeadline
    highDeadline
     * @return java.util.List<link.lycreate.bluefatty.utils.ServiceResult>
     */
    List<ServiceResult> selectServiceByDeadline(@Param("pageNow")int pageNow,@Param("lowDeadline")Timestamp lowDeadline,@Param("highDeadline") Timestamp highDeadline);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/24 11:44
     * @param pageNow
    place
     * @return java.util.List<link.lycreate.bluefatty.utils.ServiceResult>
     */
    List<ServiceResult> selectServiceByPlace(@Param("pageNow")int pageNow,@Param("place")List<Integer> place);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/24 11:53
     * @param pageNow
    lowPrice
    highPrice
     * @return java.util.List<link.lycreate.bluefatty.utils.ServiceResult>
     */
    List<ServiceResult> selectServiceByPrice(@Param("pageNow") int pageNow,@Param("lowPrice") int lowPrice,@Param("highPrice") int highPrice);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/24 13:30
     * @param pageNow
    type
     * @return java.util.List<link.lycreate.bluefatty.utils.ServiceResult>
     */
    List<ServiceResult> selectServiceByType(@Param("pageNow") int pageNow,@Param("type") List<Integer> type);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/24 16:35
     * @param pageNow
    keyword
     * @return java.util.List<link.lycreate.bluefatty.utils.ServiceResult>
     */
    List<ServiceResult> selectServiceByKeyword(@Param("pageNow") int pageNow,@Param("keyword") String keyword);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/25 19:11
     * @param serviceId
     * @return java.lang.String
     */
    String selectServiceByServiceId(int serviceId);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/26 1:41
     * @param token
    serviceId
    status
     * @return int
     */
    int updateByServiceId(@Param("token") String token,@Param("serviceId") int serviceId,@Param("status") int status);//还未实现sql

    /**
     * description
     * @author LYcreate
     * @date 2019/3/26 10:02
     * @param servantId
    typeId
    placeId
    price
    lowDeadline
    highDeadline
     * @return int
     */
    int insertService(@Param("servantId") int servantId,@Param("typeId") int typeId,@Param("placeId") int placeId,@Param("price") int price,
            @Param("lowDeadline") Timestamp lowDeadline,@Param("highDeadline") Timestamp highDeadline,
                      @Param("title") String title,@Param("content") String content);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/28 8:38
     * @param userId
    createTime
    deadline
    typeId
    placeId
    price
    title
    content
     * @return int
     */
    int insertDemand(@Param("userId") int userId,@Param("createTime") Timestamp createTime,@Param("deadline") Timestamp deadline,
                     @Param("typeId") int typeId,@Param("placeId") int placeId,@Param("price") int price,
                            @Param("title") String title,@Param("content") String content);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/28 11:08
     * @param orderId
     * @return int
     */
    int selectStatus(int orderId);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/28 17:56
     * @param dmdId
     * @return int
     */
    int selectDmderId(int dmdId);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/28 18:16
     * @param servantId
     * @return int
     */
    int selectServantId(int servantId);
}