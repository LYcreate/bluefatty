package link.lycreate.bluefatty.service.impl;

import link.lycreate.bluefatty.dao.OrderDao;
import link.lycreate.bluefatty.dao.RecordsDao;
import link.lycreate.bluefatty.model.Records;
import link.lycreate.bluefatty.service.RecordsService;
import link.lycreate.bluefatty.utils.NetResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName RecordsServiceImpl
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/3/28 10:57
 */
@Transactional(rollbackFor=Exception.class)
@Service
public class RecordsServiceImpl implements RecordsService {
    @Resource
    RecordsDao recordsDao;
    @Resource
    OrderDao orderDao;
    @Override
    public NetResult addRecord(int recorderId, int orderId) {
        int status=orderDao.selectStatus(orderId);
        NetResult netResult;
        if (status==1||status==0){
            int count=recordsDao.insert(new Records(orderId,status,recorderId));
            if (count==1){
                netResult=new NetResult(1,"提交成功!");
            }else {
                netResult=new NetResult(0,"提交失败！");
            }
            return netResult;
        }else {
            netResult=new NetResult(0,"订单状态已过期！");
            return netResult;
        }
    }

    @Override
    public NetResult deleteRecord(int recorderId, int orderId) {
        int status=orderDao.selectStatus(orderId);
        NetResult netResult;
        if (status==1||status==0){
            int count=recordsDao.deleteRecord(recorderId,orderId);
            if (count==1){
                netResult=new NetResult(1,"取消成功!");
            }else {
                netResult=new NetResult(0,"取消失败！");
            }
            return netResult;
        }else {
            netResult=new NetResult(0,"已被达成订单！");
            return netResult;
        }

    }

    @Override
    public int deleteRecordByServiceId(int orderId) {
        int count=recordsDao.deleteRecordByServiceId(orderId);
        return count;
    }
}
