package link.lycreate.bluefatty.service;

import link.lycreate.bluefatty.utils.DemandResult;
import link.lycreate.bluefatty.utils.NetResult;
import link.lycreate.bluefatty.utils.ServiceResult;
import org.apache.ibatis.annotations.Param;

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
     * 获取所有需求
     * @author LYcreate
     * @date 2019/3/22 16:01
     * @param
     * @return java.util.List<link.lycreate.bluefatty.utils.DemandResult>
     */
   List<DemandResult> getAllDemands(int pageNow);
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
   List<DemandResult>getDmdByPrice(@Param("pageNow") int pageNow, @Param("lowPrice") int lowPrice, @Param("highPrice") int highPrice);
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
    * @date 2019/3/24 9:37
    * @param pageNow
    * @return java.util.List<link.lycreate.bluefatty.utils.ServiceResult>
    */
   List<ServiceResult> getAllServices(int pageNow);
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
}
