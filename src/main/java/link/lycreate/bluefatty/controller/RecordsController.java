package link.lycreate.bluefatty.controller;

import link.lycreate.bluefatty.service.OrderService;
import link.lycreate.bluefatty.service.RecordsService;
import link.lycreate.bluefatty.service.UserService;
import link.lycreate.bluefatty.utils.NetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName RecordsController
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/3/28 10:50
 */
@RestController
public class RecordsController {
    @Autowired
    RecordsService recordsService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @RequestMapping("/applyFinish")
    public @ResponseBody
    NetResult applyFinish(HttpServletRequest request){
        System.out.println("已进入1");
        String token=request.getHeader("token");
        int userId=userService.getUserIdByToken(token);
        String strDmdId=request.getParameter("dmdId");
        int dmdId=Integer.parseInt(strDmdId);
        NetResult netResult=recordsService.addRecord(userId,dmdId);
        return netResult;
    }
    @RequestMapping("/buyService")
    public @ResponseBody NetResult buyService(HttpServletRequest request){
        String token=request.getHeader("token");
        int dmderId=userService.getUserIdByToken(token);
        String strServiceId=request.getParameter("serviceId");
        int serviceId=Integer.parseInt(strServiceId);
        NetResult netResult=recordsService.addRecord(dmderId,serviceId);
        return netResult;
    }
    @RequestMapping("/cancelRecord")
    public @ResponseBody NetResult cancelDemand(HttpServletRequest request){
        String token=request.getHeader("token");
        int recorderId=userService.getUserIdByToken(token);
        String strOrderId=request.getParameter("orderId");
        int orderId=Integer.parseInt(strOrderId);
        NetResult netResult=recordsService.deleteRecord(recorderId,orderId);
        return netResult;
    }

}
