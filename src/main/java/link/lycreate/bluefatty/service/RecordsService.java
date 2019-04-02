package link.lycreate.bluefatty.service;

import link.lycreate.bluefatty.utils.NetResult;

/**
 * RecordsService
 *
 * @author LYcreate
 * @date 2019/3/28 10:51
 */
public interface RecordsService {
    /**
     * description
     * @author LYcreate
     * @date 2019/3/28 10:56
     * @param recorderId
    orderId
     * @return link.lycreate.bluefatty.utils.NetResult
     */
    NetResult addRecord(int recorderId,int orderId);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/28 10:56
     * @param recorderId
    orderId
     * @return link.lycreate.bluefatty.utils.NetResult
     */
    NetResult deleteRecord(int recorderId,int orderId);
    /**
     * description
     * @author LYcreate
     * @date 2019/4/2 3:20
     * @param orderId
     * @return int
     */
    int deleteRecordByServiceId(int orderId);

}
