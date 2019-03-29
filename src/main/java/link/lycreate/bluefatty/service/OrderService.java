package link.lycreate.bluefatty.service;

import link.lycreate.bluefatty.utils.DemandResult;
import link.lycreate.bluefatty.utils.NetResult;
import link.lycreate.bluefatty.utils.ServiceResult;
import org.apache.ibatis.annotations.Param;

import javax.annotation.security.PermitAll;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

/**
 * OrderService
 *
 * @author LYcreate
 * @date 2019/3/22 15:54
 */
public interface OrderService {
    /**
     * description
     * @author LYcreate
     * @date 2019/3/26 19:41
     * @param pageNow
    universityId
    place
    lowDeadline
    highDeadline
    lowPrice
    highPrice
    type
     * @return java.util.List<link.lycreate.bluefatty.utils.DemandResult>
     */
   List<DemandResult> getAllDemands(int pageNow,int universityId, List<Integer> place,Timestamp lowDeadline,
                                    Timestamp highDeadline, int lowPrice, int highPrice,List<Integer> type);
   /**
    * description
    * @author LYcreate
    * @date 2019/3/22 17:52
    * @param pageNow
   deadLine
    * @return java.util.List<link.lycreate.bluefatty.utils.DemandResult>
    */
   List<DemandResult> getDmdByDeadline(int pageNow, Timestamp lowDeadLine,Timestamp highDeadLine);
   /**
    * description
    * @author LYcreate
    * @date 2019/3/22 17:52
    * @param pageNow
   place
    * @return java.util.List<link.lycreate.bluefatty.utils.DemandResult>
    */
   List<DemandResult> getDmdByPlace(int pageNow,List<Integer> place);
   /**
    * description
    * @author LYcreate
    * @date 2019/3/23 21:36
    * @param pageNow
   type
    * @return java.util.List<link.lycreate.bluefatty.utils.DemandResult>
    */
   List<DemandResult>getDmdByType(int pageNow,List<Integer> type);
   /**
    * description
    * @author LYcreate
    * @date 2019/3/24 9:36
    * @param pageNow
   lowPrice
   highPrice
    * @return java.util.List<link.lycreate.bluefatty.utils.DemandResult>
    */
   List<DemandResult>getDmdByPrice(int pageNow, int lowPrice, int highPrice);
   /**
    * description
    * @author LYcreate
    * @date 2019/3/24 17:39
    * @param pageNow
   keyword
    * @return java.util.List<link.lycreate.bluefatty.utils.DemandResult>
    */
   List<DemandResult>getDmdByKeyword(@Param("pageNow")int pageNow,@Param("keyword")String keyword);
   /**
    * description
    * @author LYcreate
    * @date 2019/3/25 18:40
    * @param dmdId
    * @return java.lang.String
    */
   String getDmdByDmdId(int dmdId);
   /**
    * description
    * @author LYcreate
    * @date 2019/3/26 21:58
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
   List<ServiceResult> getAllServices(int pageNow,int universityId, List<Integer> place,Timestamp lowDeadline,
                                      Timestamp highDeadline, int lowPrice, int highPrice,List<Integer> type);
   /**
    * description
    * @author LYcreate
    * @date 2019/3/24 11:32
    * @param pageNow
   lowDeadline
   highDeadline
    * @return java.util.List<link.lycreate.bluefatty.utils.ServiceResult>
    */
   List<ServiceResult> getServiceByDeadline(int pageNow,Timestamp lowDeadline,Timestamp highDeadline);
   /**
    * description
    * @author LYcreate
    * @date 2019/3/24 11:42
    * @param pageNow
   place
    * @return java.util.List<link.lycreate.bluefatty.utils.ServiceResult>
    */
   List<ServiceResult> getServiceByPlace(int pageNow,List<Integer> place);
   /**
    * description
    * @author LYcreate
    * @date 2019/3/24 11:55
    * @param pageNow
   price
    * @return java.util.List<link.lycreate.bluefatty.utils.ServiceResult>
    */
   List<ServiceResult> getServiceByPrice(int pageNow, int lowPrice,int highPrice);
   /**
    * description
    * @author LYcreate
    * @date 2019/3/24 12:46
    * @param pageNow
   type
    * @return java.util.List<link.lycreate.bluefatty.utils.ServiceResult>
    */
   List<ServiceResult> getServiceByType(int pageNow,List<Integer> type);
   /**
    * description
    * @author LYcreate
    * @date 2019/3/24 16:34
    * @param pageNow
   kewword
    * @return java.util.List<link.lycreate.bluefatty.utils.ServiceResult>
    */
   List<ServiceResult> getServiceByKeyword(int pageNow,String kewword);
   /**
    * description
    * @author LYcreate
    * @date 2019/3/25 19:10
    * @param serviceId
    * @return java.lang.String
    */
   String getServiceByServiceId(int serviceId);

   NetResult applyService(String token, int serviceId);
   /**
    * description
    * @author LYcreate
    * @date 2019/3/26 9:54
    * @param servantId
   typeId
   placeId
   price
   lowDeadline
   highDeadline
    * @return link.lycreate.bluefatty.utils.NetResult
    */
   NetResult addService(int servantId, int typeId, int placeId, int price, Timestamp lowDeadline, Timestamp highDeadline,
                        String title,String content);
   /**
    * description
    * @author LYcreate
    * @date 2019/3/28 8:34
    * @param userId
   createTime
   deadline
   typeId
   placeId
   price
   title
   content
    * @return link.lycreate.bluefatty.utils.NetResult
    */
   NetResult publishDemand(int userId,Timestamp createTime,Timestamp deadline,int typeId,int placeId,int price,
                           String title,String content);
   /**
    * description
    * @author LYcreate
    * @date 2019/3/28 17:42
    * @param dmderId
   dmdId
    * @return link.lycreate.bluefatty.utils.NetResult
    */
   NetResult deleteDemand(int dmderId,int dmdId);
   /**
    * description
    * @author LYcreate
    * @date 2019/3/28 18:13
    * @param servantId
   serviceId
    * @return link.lycreate.bluefatty.utils.NetResult
    */
   NetResult deleteService(int servantId,int serviceId);

   NetResult confirmService(int servantId,int dmderId,int serviceId);
}
