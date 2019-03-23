package link.lycreate.bluefatty.controller;

import link.lycreate.bluefatty.service.OrderService;
import link.lycreate.bluefatty.utils.DemandResult;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/3/21 16:30
 */
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;
    @RequestMapping("/getAllDemands")
    public @ResponseBody
    Map<String,Object> getAllDemands(@RequestParam int pageNow){
        List<DemandResult> dmdArray=orderService.getAllDemands(pageNow);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("dmdArray",dmdArray);
        return resultMap;
    }

    @RequestMapping("/getDmdByDeadline")
    public @ResponseBody Map<String, Object> getDmdByDeadline(HttpServletRequest request){
        String strPageNow=request.getParameter("pageNow");
        int pageNow=Integer.parseInt(strPageNow);
        String strLowDeadline=request.getParameter("lowDeadline");
        Timestamp lowDeadline=Timestamp.valueOf(strLowDeadline);
        String strHighDeadline=request.getParameter("highDeadline");
        Timestamp highDeadline=Timestamp.valueOf(strHighDeadline);
        List<DemandResult> dmdArray=orderService.getDmdByDeadline(pageNow,lowDeadline,highDeadline);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("dmdArray",dmdArray);
        return resultMap;
    }

    @RequestMapping("/getDmdByPlace")
    public @ResponseBody Map<String,Object> getDmdByPlaceId(HttpServletRequest request){
        String strPageNow=request.getParameter("pageNow");
        int pageNow=Integer.parseInt(strPageNow);
        String strPlace=request.getParameter("place");
        System.out.println("strPlace"+strPlace);
        String[] placeArray=strPlace.split("\\[|,|\\]");
        List<Integer> place=new ArrayList<>();
        for (int i = 1; i < placeArray.length; i++) {
            System.out.println(placeArray[i]);
            place.add(Integer.parseInt(placeArray[i]));
        }
        List<DemandResult> dmdArray=orderService.getDmdByPlace(pageNow,place);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("dmdArray",dmdArray);
        return resultMap;
    }

    @RequestMapping("/getDmdByType")
    public @ResponseBody Map<String,Object> getDmdByType(HttpServletRequest request){
        String strPageNow=request.getParameter("pageNow");
        int pageNow=Integer.parseInt(strPageNow);
        String strType=request.getParameter("type");
        System.out.println("strPlace"+strType);
        String[] typeArray=strType.split("\\[|,|\\]");
        List<Integer> type=new ArrayList<>();
        for (int i = 1; i < typeArray.length; i++) {
            System.out.println(typeArray[i]);
            type.add(Integer.parseInt(typeArray[i]));
        }
        List<DemandResult> dmdArray=orderService.getDmdByType(pageNow,type);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("dmdArray",dmdArray);
        return resultMap;
    }
    @RequestMapping("/getDmdByPrice")
    public @ResponseBody Map<String,Object> getDmdByPrice(HttpServletRequest request){
        String strPageNow=request.getParameter("pageNow");
        int pageNow=Integer.parseInt(strPageNow);
        System.out.println("controller"+pageNow);
        String strLowPrice=request.getParameter("lowPrice");
        String strHighPrice=request.getParameter("highPrice");
        int lowPrice=Integer.parseInt(strLowPrice);
        int highPrice=Integer.parseInt(strHighPrice);
        List<DemandResult> dmdArray=orderService.getDmdByPrice(pageNow,lowPrice,highPrice);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("dmdArray",dmdArray);
        return resultMap;
    }
}
