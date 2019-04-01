package link.lycreate.bluefatty.service.impl;

import link.lycreate.bluefatty.dao.OrderDao;
import link.lycreate.bluefatty.dao.RecordsDao;
import link.lycreate.bluefatty.model.Order;
import link.lycreate.bluefatty.model.Records;
import link.lycreate.bluefatty.service.OrderService;
import link.lycreate.bluefatty.utils.DemandResult;
import link.lycreate.bluefatty.utils.NetResult;
import link.lycreate.bluefatty.utils.OrdersResult;
import link.lycreate.bluefatty.utils.ServiceResult;
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
    @Resource
    private RecordsDao recordsDao;

    @Override
    public List<DemandResult> getAllDemands(int pageNow, int universityId, List<Integer> place, Timestamp lowDeadline,
                                            Timestamp highDeadline, int lowPrice, int highPrice, List<Integer> type) {
        List<DemandResult> orderList = orderDao.selectDmdByPage(pageNow, universityId, place, lowDeadline, highDeadline,
                lowPrice, highPrice, type);
        System.out.println("返回成功");
        return orderList;
    }

    @Override
    public List<DemandResult> getDmdByDeadline(int pageNow, Timestamp lowDeadline, Timestamp highDeadline) {
        List<DemandResult> orderList = orderDao.selectDmdByDeadline(pageNow, lowDeadline, highDeadline);
        return orderList;
    }

    @Override
    public List<DemandResult> getDmdByPlace(int pageNow, List<Integer> place) {
        List<DemandResult> orderList = orderDao.selectDmdByPlace(pageNow, place);
        return orderList;
    }

    @Override
    public List<DemandResult> getDmdByType(int pageNow, List<Integer> type) {
        List<DemandResult> orderList = orderDao.selectDmdByType(pageNow, type);
        return orderList;
    }

    @Override
    public List<DemandResult> getDmdByPrice(int pageNow, int lowPrice, int highPrice) {
        System.out.println("low:" + lowPrice + "high:" + highPrice);
        System.out.println("service" + pageNow);
        List<DemandResult> orderList = orderDao.selectDmdByPrice(pageNow, lowPrice, highPrice);
        return orderList;
    }

    @Override
    public List<DemandResult> getDmdByKeyword(int pageNow, String keyword) {
        List<DemandResult> orderList = orderDao.selectDmdByKeyword(pageNow, keyword);
        return orderList;
    }

    @Override
    public String getDmdByDmdId(int dmdId) {
        String content = orderDao.selectDmdByDmdId(dmdId);
        return content;
    }

    @Override
    public NetResult deleteDemand(int dmderId, int dmdId) {
        int rdmdId = orderDao.selectDmderId(dmdId);
        if (rdmdId == dmderId) {
            int count = orderDao.deleteByPrimaryKey(dmdId);
            if (count == 1) {
                return new NetResult(1, "删除成功！");
            } else {
                return new NetResult(0, "删除失败！");
            }
        } else {
            return new NetResult(0, "删除失败！");
        }
    }

    @Override
    public List<ServiceResult> getAllServices(int pageNow, int universityId, List<Integer> place, Timestamp lowDeadline,
                                              Timestamp highDeadline, int lowPrice, int highPrice, List<Integer> type) {
        List<ServiceResult> orderList = orderDao.selectServiceByPage(pageNow, universityId, place, lowDeadline, highDeadline,
                lowPrice, highPrice, type);
        return orderList;
    }

    @Override
    public List<ServiceResult> getServiceByDeadline(int pageNow, Timestamp lowDeadline, Timestamp highDeadline) {
        List<ServiceResult> orderList = orderDao.selectServiceByDeadline(pageNow, lowDeadline, highDeadline);
        return orderList;
    }

    @Override
    public List<ServiceResult> getServiceByPlace(int pageNow, List<Integer> place) {
        List<ServiceResult> orderList = orderDao.selectServiceByPlace(pageNow, place);
        return orderList;
    }

    @Override
    public List<ServiceResult> getServiceByPrice(int pageNow, int lowPrice, int highPrice) {
        List<ServiceResult> orderList = orderDao.selectServiceByPrice(pageNow, lowPrice, highPrice);
        return orderList;
    }

    @Override
    public List<ServiceResult> getServiceByType(int pageNow, List<Integer> type) {
        List<ServiceResult> orderList = orderDao.selectServiceByType(pageNow, type);
        return orderList;
    }

    @Override
    public List<ServiceResult> getServiceByKeyword(int pageNow, String keyword) {
        List<ServiceResult> orderList = orderDao.selectServiceByKeyword(pageNow, keyword);
        return orderList;
    }

    @Override
    public String getServiceByServiceId(int serviceId) {
        String content = orderDao.selectServiceByServiceId(serviceId);
        return content;
    }

    @Override
    public NetResult applyService(String token, int serviceId) {
        //微信服务消息的转发
        int result = orderDao.updateByServiceId(token, serviceId, 2);
        if (result == 1) {
            NetResult netResult = new NetResult(1, "已提交申请!");
            return netResult;
        } else {
            NetResult netResult = new NetResult(0, "提交失败！");
            return netResult;
        }
    }

    @Override
    public NetResult addService(int servantId, int typeId, int placeId, int price, Timestamp lowDeadline, Timestamp highDeadline,
                                String title, String content) {
        int result = orderDao.insertService(servantId, typeId, placeId, price, lowDeadline, highDeadline, title, content);
        if (result == 1) {
            NetResult netResult = new NetResult(1, "发布成功！");
            return netResult;
        } else {
            NetResult netResult = new NetResult(0, "发布失败！");
            return netResult;
        }
    }

    @Override
    public NetResult deleteService(int servantId, int serviceId) {
        int rservantId = orderDao.selectServantId(serviceId);
        if (rservantId == servantId) {
            int count = orderDao.deleteByPrimaryKey(serviceId);
            if (count == 1) {
                return new NetResult(1, "删除成功！");
            } else {
                return new NetResult(0, "删除失败！");
            }
        } else {
            return new NetResult(0, "删除失败！");
        }
    }

    @Override
    public NetResult publishDemand(int userId, Timestamp createTime, Timestamp deadline, int typeId, int placeId, int price, String title, String content) {
        int count = orderDao.insertDemand(userId, createTime, deadline, typeId, placeId, price, title, content);
        NetResult netResult;
        if (count == 1) {
            netResult = new NetResult(1, "发布成功！");
            return netResult;
        } else {
            netResult = new NetResult(0, "发布失败！");
            return netResult;
        }
    }

    @Override
    public NetResult confirmService(int servantId, int dmderId, int serviceId) {
        NetResult netResult;
        Order service = orderDao.selectByPrimaryKey(serviceId);
        int orderStatus = service.getStatus();
        if (service == null) {
            netResult = new NetResult(0, "订单不存在！");
        } else if (service.getServantId() != servantId) {
            netResult = new NetResult(0, "无权限！");
        } else if (orderStatus >= 2) {
            netResult = new NetResult(0, "已达成订单无法更改！");
        } else if (orderStatus == -1) {
            netResult = new NetResult(0, "订单已过期！");
        } else if (orderStatus == 1) {
            netResult = new NetResult(0, "需求单无法指定雇主！");
        } else {
            Records record = recordsDao.selectRecordByDmderIdAndServiceId(dmderId, serviceId);
            int recordStatus = record.getStatus();
            if (recordStatus == 1) {
                netResult = new NetResult(0, "订单状态异常！");
            } else if (recordStatus > 2) {
                netResult = new NetResult(0, "已达成订单无法更改！");
            } else if (recordStatus == -1) {
                netResult = new NetResult(0, "订单已过期！");
            } else {
                int orderFlag = orderDao.updateServiceConfirm(dmderId, serviceId, 2);
                int recordsFlag=recordsDao.updateRecords(dmderId, serviceId, 2);
                if (orderFlag == 1 && recordsFlag==1) {
                    netResult = new NetResult(1, "订单已达成！");
                } else {
                    netResult = new NetResult(0, "订单达成失败！");
                }
            }
        }
        return netResult;
    }

    @Override
    public List<ServiceResult> getServiceOrder(int servantId) {
        List<ServiceResult> recordServiceOrder=orderDao.selectRecordServiceOrder(servantId);
        List<ServiceResult> serviceOrderList=orderDao.selectServiceOrderByServiceId(servantId);
        serviceOrderList.addAll(recordServiceOrder);
        return serviceOrderList;
    }
}
