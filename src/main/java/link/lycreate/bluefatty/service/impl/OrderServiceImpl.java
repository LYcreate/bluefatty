package link.lycreate.bluefatty.service.impl;

import link.lycreate.bluefatty.dao.OrderDao;
import link.lycreate.bluefatty.service.OrderService;
import link.lycreate.bluefatty.utils.DemandResult;
import link.lycreate.bluefatty.utils.NetResult;
import link.lycreate.bluefatty.utils.ServiceResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.nio.ch.Net;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/3/22 16:09
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Override
    public List<DemandResult> getAllDemands(int pageNow) {
        List<DemandResult> orderList=orderDao.selectDmdByPage(pageNow);
        return orderList;
    }

    @Override
    public List<DemandResult> getDmdByDeadline(int pageNow, Timestamp lowDeadline,Timestamp highDeadline) {
        List<DemandResult> orderList=orderDao.selectDmdByDeadline(pageNow,lowDeadline,highDeadline);
        return orderList;
    }

    @Override
    public List<DemandResult> getDmdByPlace(int pageNow, List<Integer> place) {
        List<DemandResult> orderList=orderDao.selectDmdByPlace(pageNow,place);
        return orderList;
    }

    @Override
    public List<DemandResult> getDmdByType(int pageNow, List<Integer> type) {
        List<DemandResult> orderList=orderDao.selectDmdByType(pageNow,type);
        return orderList;
    }

    @Override
    public List<DemandResult> getDmdByPrice(int pageNow, int lowPrice, int highPrice) {
        System.out.println("low:"+lowPrice+"high:"+highPrice);
        System.out.println("service"+pageNow);
        List<DemandResult> orderList=orderDao.selectDmdByPrice(pageNow,lowPrice,highPrice);
        return orderList;
    }

    @Override
    public List<DemandResult> getDmdByKeyword(int pageNow, String keyword) {
        List<DemandResult> orderList=orderDao.selectDmdByKeyword(pageNow,keyword);
        return orderList;
    }

    @Override
    public String getDmdByDmdId(int dmdId) {
        String content=orderDao.selectDmdByDmdId(dmdId);
        return content;
    }

    @Override
    public List<ServiceResult> getAllServices(int pageNow) {
        List<ServiceResult> orderList=orderDao.selectServiceByPage(pageNow);
        return orderList;
    }

    @Override
    public List<ServiceResult> getServiceByDeadline(int pageNow, Timestamp lowDeadline, Timestamp highDeadline) {
        List<ServiceResult> orderList=orderDao.selectServiceByDeadline(pageNow,lowDeadline,highDeadline);
        return orderList;
    }

    @Override
    public List<ServiceResult> getServiceByPlace(int pageNow, List<Integer> place) {
        List<ServiceResult> orderList=orderDao.selectServiceByPlace(pageNow,place);
        return orderList;
    }

    @Override
    public List<ServiceResult> getServiceByPrice(int pageNow, int lowPrice,int highPrice) {
        List<ServiceResult> orderList=orderDao.selectServiceByPrice(pageNow,lowPrice,highPrice);
        return orderList;
    }

    @Override
    public List<ServiceResult> getServiceByType(int pageNow, List<Integer> type) {
        List<ServiceResult> orderList=orderDao.selectServiceByType(pageNow,type);
        return orderList;
    }

    @Override
    public List<ServiceResult> getServiceByKeyword(int pageNow, String keyword) {
        List<ServiceResult> orderList=orderDao.selectServiceByKeyword(pageNow,keyword);
        return orderList;
    }

    @Override
    public String getServiceByServiceId(int serviceId) {
        String content=orderDao.selectServiceByServiceId(serviceId);
        return content;
    }

    @Override
    public NetResult applyService(String token, int serviceId) {
        int result=orderDao.updateByServiceId(token,serviceId,2);
        if (result==1){
            NetResult netResult=new NetResult(1,"已提交申请!");
            return netResult;
        }else {
            NetResult netResult=new NetResult(0,"提交失败！");
            return netResult;
        }
    }
}
