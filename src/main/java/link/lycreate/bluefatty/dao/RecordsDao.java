package link.lycreate.bluefatty.dao;

import link.lycreate.bluefatty.model.Records;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RecordsDao {
    int deleteByPrimaryKey(Integer recordId);

    int insert(Records record);

    int insertSelective(Records record);

    Records selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(Records record);

    int updateByPrimaryKey(Records record);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/28 11:13
     * @param recorderId
    orderId
     * @return int
     */
    int deleteRecord(@Param("recorderId")int recorderId,@Param("orderId") int orderId);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/30 12:30
     * @param dmderId
    serviceId
     * @return link.lycreate.bluefatty.model.Records
     */
    Records selectRecordByDmderIdAndServiceId(@Param("dmderId") int dmderId,@Param("serviceId") int serviceId);
    /**
     * description
     * @author LYcreate
     * @date 2019/3/30 12:48
     * @param orderId
    recorderId
    status
     * @return int
     */
    int updateRecords(@Param("orderId")int orderId,@Param("recorderId")int recorderId, @Param("status") int status);
    /**
     * description
     * @author LYcreate
     * @date 2019/4/2 3:23
     * @param orderId
     * @return int
     */
    int deleteRecordByServiceId(int orderId);
    /**
     * description
     * @author LYcreate
     * @date 2019/4/2 11:36
     * @param servantId
    dmdId
     * @return link.lycreate.bluefatty.model.Records
     */
    Records selectRecordByServantAndDmdId(@Param("servantId") int servantId,@Param("dmdId") int dmdId);

}