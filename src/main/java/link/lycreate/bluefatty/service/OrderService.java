package link.lycreate.bluefatty.service;

import link.lycreate.bluefatty.utils.DemandResult;

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

   List<DemandResult>getDmdByPrice(int pageNow,int lowPrice,int highPrice);
}
