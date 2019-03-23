package link.lycreate.bluefatty.service.impl;

import link.lycreate.bluefatty.dao.OrderDao;
import link.lycreate.bluefatty.service.OrderService;
import link.lycreate.bluefatty.utils.DemandResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
