package link.lycreate.bluefatty.controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import link.lycreate.bluefatty.service.OrderService;
import link.lycreate.bluefatty.service.RecordsService;
import link.lycreate.bluefatty.service.UserService;
import link.lycreate.bluefatty.utils.DemandResult;
import link.lycreate.bluefatty.utils.NetResult;
import link.lycreate.bluefatty.utils.ServiceResult;
import link.lycreate.bluefatty.utils.StrUtil;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.*;

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
    @Autowired
    UserService userService;

    @RequestMapping("/getAllDemands")
    public @ResponseBody
    Map<String,Object> getAllDemands(HttpServletRequest request){
        String a=null;
        System.out.println("a");
        System.out.println(a==null);
        //pageNow
        String strPageNow=request.getParameter("pageNow");
        int pageNow=Integer.parseInt(strPageNow);
        String strUniversityId=request.getParameter("universityId");
        Integer universityId=Integer.parseInt(strUniversityId);
        //place
        String strPlace=request.getParameter("place");
        String[] placeArray=strPlace.split("\\[|,|\\]");
        List<Integer> place=new ArrayList<>();
        for (int i = 1; i < placeArray.length; i++) {
            System.out.println(placeArray[i]);
            place.add(Integer.parseInt(placeArray[i]));
        }
        //deadline
        String strLowDeadline=request.getParameter("lowDeadline");
        System.out.println(strLowDeadline.equals("null"));
        Timestamp lowDeadline=strLowDeadline.equals("null")?null:Timestamp.valueOf(strLowDeadline);
        String strHighDeadline=request.getParameter("highDeadline");
        Timestamp highDeadline=strLowDeadline.equals("null")?null:Timestamp.valueOf(strHighDeadline);
        //type
        String strType=request.getParameter("type");
        System.out.println("strPlace"+strType);
        String[] typeArray=strType.split("\\[|,|\\]");
        List<Integer> type=new ArrayList<>();
        for (int i = 1; i < typeArray.length; i++) {
            System.out.println(typeArray[i]);
            type.add(Integer.parseInt(typeArray[i]));
        }
        //price
        String strLowPrice=request.getParameter("lowPrice");
        String strHighPrice=request.getParameter("highPrice");
        Integer lowPrice=strLowPrice.equals("null")?-1:Integer.parseInt(strLowPrice);
        Integer highPrice=strHighPrice.equals("null")?-1:Integer.parseInt(strHighPrice);
        List<DemandResult> dmdArray=orderService.getAllDemands(pageNow,universityId,place,lowDeadline,highDeadline,
                lowPrice,highPrice,type);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("dmdArray",dmdArray);
        return resultMap;
    }
    @RequestMapping("/deleteDemand")
    public @ResponseBody NetResult deleteDemand(HttpServletRequest request){
        String token=request.getHeader("token");
        Integer dmderId=userService.getUserIdByToken(token);
        if (dmderId==null){
            return  new NetResult(0,"会话错误！");
        }
        String strDmdId=request.getParameter("dmdId");
        int dmdId=Integer.parseInt(strDmdId);
        NetResult netResult=orderService.deleteDemand(dmderId,dmdId);
        return netResult;
    }
//    @RequestMapping("/getDmdByDeadline")
//    public @ResponseBody Map<String, Object> getDmdByDeadline(HttpServletRequest request){
//        String strPageNow=request.getParameter("pageNow");
//        int pageNow=Integer.parseInt(strPageNow);
//        String strLowDeadline=request.getParameter("lowDeadline");
//        Timestamp lowDeadline=Timestamp.valueOf(strLowDeadline);
//        String strHighDeadline=request.getParameter("highDeadline");
//        Timestamp highDeadline=Timestamp.valueOf(strHighDeadline);
//        List<DemandResult> dmdArray=orderService.getDmdByDeadline(pageNow,lowDeadline,highDeadline);
//        Map<String,Object> resultMap=new HashMap<>();
//        resultMap.put("dmdArray",dmdArray);
//        return resultMap;
//    }
//
//    @RequestMapping("/getDmdByPlace")
//    public @ResponseBody Map<String,Object> getDmdByPlaceId(HttpServletRequest request){
//        String strPageNow=request.getParameter("pageNow");
//        int pageNow=Integer.parseInt(strPageNow);
//        String strPlace=request.getParameter("place");
//        System.out.println("strPlace"+strPlace);
//        String[] placeArray=strPlace.split("\\[|,|\\]");
//        List<Integer> place=new ArrayList<>();
//        for (int i = 1; i < placeArray.length; i++) {
//            System.out.println(placeArray[i]);
//            place.add(Integer.parseInt(placeArray[i]));
//        }
//        List<DemandResult> dmdArray=orderService.getDmdByPlace(pageNow,place);
//        Map<String,Object> resultMap=new HashMap<>();
//        resultMap.put("dmdArray",dmdArray);
//        return resultMap;
//    }
//
//    @RequestMapping("/getDmdByType")
//    public @ResponseBody Map<String,Object> getDmdByType(HttpServletRequest request){
//        String strPageNow=request.getParameter("pageNow");
//        int pageNow=Integer.parseInt(strPageNow);
//        String strType=request.getParameter("type");
//        System.out.println("strPlace"+strType);
//        String[] typeArray=strType.split("\\[|,|\\]");
//        List<Integer> type=new ArrayList<>();
//        for (int i = 1; i < typeArray.length; i++) {
//            System.out.println(typeArray[i]);
//            type.add(Integer.parseInt(typeArray[i]));
//        }
//        List<DemandResult> dmdArray=orderService.getDmdByType(pageNow,type);
//        Map<String,Object> resultMap=new HashMap<>();
//        resultMap.put("dmdArray",dmdArray);
//        return resultMap;
//    }
//    @RequestMapping("/getDmdByPrice")
//    public @ResponseBody Map<String,Object> getDmdByPrice(HttpServletRequest request){
//        String strPageNow=request.getParameter("pageNow");
//        int pageNow=Integer.parseInt(strPageNow);
//        System.out.println("controller"+pageNow);
//        String strLowPrice=request.getParameter("lowPrice");
//        String strHighPrice=request.getParameter("highPrice");
//        int lowPrice=Integer.parseInt(strLowPrice);
//        int highPrice=Integer.parseInt(strHighPrice);
//        List<DemandResult> dmdArray=orderService.getDmdByPrice(pageNow,lowPrice,highPrice);
//        Map<String,Object> resultMap=new HashMap<>();
//        resultMap.put("dmdArray",dmdArray);
//        return resultMap;
//    }

    @RequestMapping("/getDmdByKeyword")
    public @ResponseBody Map<String,Object> getDmdByKeyword(HttpServletRequest request){
        String strPageNow=request.getParameter("pageNow");
        int pageNow=Integer.parseInt(strPageNow);
        String keyword=request.getParameter("keyword");
        List<DemandResult> dmdArray=orderService.getDmdByKeyword(pageNow,keyword);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("dmdArray",dmdArray);
        return resultMap;
    }

    @RequestMapping("/getDmdByDmdId")
    public @ResponseBody Map<String,Object> getDmdByDmdId(HttpServletRequest request){
        String strDmdId=request.getParameter("dmdId");
        int dmdId=Integer.parseInt(strDmdId);
        String contet=orderService.getDmdByDmdId(dmdId);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("content",contet);
        return resultMap;
    }
    @RequestMapping("/publishDemand")
    public @ResponseBody NetResult publishDemand(HttpServletRequest request){
        System.out.println("进入");
        String token=request.getHeader("token");
        Integer userId=userService.getUserIdByToken(token);
        if (userId==0){
            return new NetResult(0,"会话错误！");
        }
        System.out.println("userId:"+userId);
        String strDeadline=request.getParameter("deadline");
        Timestamp deadline=Timestamp.valueOf(strDeadline);
        Date date=new Date();
        Timestamp createTime=new Timestamp(date.getTime());
        String strTypeId=request.getParameter("typeId");
        int typeId=Integer.parseInt(strTypeId);
        String strPlaceId=request.getParameter("placeId");
        int placeId=Integer.parseInt(strPlaceId);
        String strPrice=request.getParameter("price");
        int price=Integer.parseInt(strPrice);
        String content=request.getParameter("content");
        String title=StrUtil.cutStr(content,32);
        NetResult netResult=orderService.publishDemand(userId,createTime,deadline,typeId,placeId,price,title,content);
        System.out.println(netResult.toString());
        return netResult;
    }

    @RequestMapping("/getAllServices")
    public @ResponseBody Map<String,Object> getAllServices(HttpServletRequest request){
        //pageNow
        String strPageNow=request.getParameter("pageNow");
        int pageNow=Integer.parseInt(strPageNow);
        String strUniversityId=request.getParameter("universityId");
        Integer universityId=Integer.parseInt(strUniversityId);
        //place
        String strPlace=request.getParameter("place");
        String[] placeArray=strPlace.split("\\[|,|\\]");
        List<Integer> place=new ArrayList<>();
        for (int i = 1; i < placeArray.length; i++) {
            System.out.println(placeArray[i]);
            place.add(Integer.parseInt(placeArray[i]));
        }
        //deadline
        String strLowDeadline=request.getParameter("lowDeadline");
        Timestamp lowDeadline=strLowDeadline.equals("null")?null:Timestamp.valueOf(strLowDeadline);
        String strHighDeadline=request.getParameter("highDeadline");
        Timestamp highDeadline=strHighDeadline.equals("null")?null:Timestamp.valueOf(strHighDeadline);
        //type
        String strType=request.getParameter("type");
        System.out.println("strPlace"+strType);
        String[] typeArray=strType.split("\\[|,|\\]");
        List<Integer> type=new ArrayList<>();
        for (int i = 1; i < typeArray.length; i++) {
            System.out.println(typeArray[i]);
            type.add(Integer.parseInt(typeArray[i]));
        }
        //price
        String strLowPrice=request.getParameter("lowPrice");
        String strHighPrice=request.getParameter("highPrice");
        int lowPrice=strLowPrice.equals("null")?-1:Integer.parseInt(strLowPrice);
        int highPrice=strHighPrice.equals("null")?-1:Integer.parseInt(strHighPrice);
        List<ServiceResult> serviceArray=orderService.getAllServices(pageNow,universityId,place,lowDeadline,highDeadline,
                lowPrice,highPrice,type);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("serviceArray",serviceArray);
        return resultMap;
    }
    @RequestMapping("/deleteService")
    public @ResponseBody NetResult deleteService(HttpServletRequest request){
        String token=request.getHeader("token");
        Integer servantId=userService.getUserIdByToken(token);
        if (servantId==null){
            return  new NetResult(0,"会话错误！");
        }
        String strServiceId=request.getParameter("serviceId");
        int serviceId=Integer.parseInt(strServiceId);
        NetResult netResult=orderService.deleteService(servantId,serviceId);
        return netResult;
    }

//    @RequestMapping("/getServiceByDeadline")
//    public @ResponseBody Map<String,Object> getServiceByDeadline(HttpServletRequest request){
//        String strPageNow=request.getParameter("pageNow");
//        int pageNow=Integer.parseInt(strPageNow);
//        String strLowDeadline=request.getParameter("lowDeadline");
//        Timestamp lowDeadline=Timestamp.valueOf(strLowDeadline);
//        String strHighDeadline=request.getParameter("highDeadline");
//        Timestamp highDeadline=Timestamp.valueOf(strHighDeadline);
//        List<ServiceResult> serviceArray=orderService.getServiceByDeadline(pageNow,lowDeadline,highDeadline);
//        Map<String,Object> resultMap=new HashMap<>();
//        resultMap.put("serviceArray",serviceArray);
//        return resultMap;
//    }
//    @RequestMapping("/getServiceByPlace")
//    public @ResponseBody Map<String,Object> getServiceByPlace(HttpServletRequest request) {
//        String strPageNow = request.getParameter("pageNow");
//        int pageNow = Integer.parseInt(strPageNow);
//        String strPlace=request.getParameter("place");
//        System.out.println("strPlace"+strPlace);
//        String[] placeArray=strPlace.split("\\[|,|\\]");
//        List<Integer> place=new ArrayList<>();
//        for (int i = 1; i < placeArray.length; i++) {
//            System.out.println(placeArray[i]);
//            place.add(Integer.parseInt(placeArray[i]));
//        }
//        List<ServiceResult> serviceArray=orderService.getServiceByPlace(pageNow,place);
//        Map<String,Object> resultMap=new HashMap<>();
//        resultMap.put("serviceArray",serviceArray);
//        return resultMap;
//    }
//    @RequestMapping("/getServiceByPrice")
//    public @ResponseBody Map<String,Object> getServiceByPrice(HttpServletRequest request){
//        String strPageNow=request.getParameter("pageNow");
//        int pageNow=Integer.parseInt(strPageNow);
//        String strLowPrice=request.getParameter("lowPrice");
//        String strHighPrice=request.getParameter("highPrice");
//        int lowPrice=Integer.parseInt(strLowPrice);
//        int highPrice=Integer.parseInt(strHighPrice);
//        List<ServiceResult> serviceArray=orderService.getServiceByPrice(pageNow,lowPrice,highPrice);
//        Map<String,Object> resultMap=new HashMap<>();
//        resultMap.put("serviceArray",serviceArray);
//        return resultMap;
//    }
//    @RequestMapping("/getServiceByType")
//    public @ResponseBody Map<String,Object> getServiceByType(HttpServletRequest request){
//        String strPageNow=request.getParameter("pageNow");
//        int pageNow=Integer.parseInt(strPageNow);
//        String strType=request.getParameter("type");
//        System.out.println("strPlace"+strType);
//        String[] typeArray=strType.split("\\[|,|\\]");
//        List<Integer> type=new ArrayList<>();
//        for (int i = 1; i < typeArray.length; i++) {
//            System.out.println(typeArray[i]);
//            type.add(Integer.parseInt(typeArray[i]));
//        }
//        List<ServiceResult> serviceArray=orderService.getServiceByType(pageNow,type);
//        Map<String,Object> resultMap=new HashMap<>();
//        resultMap.put("serviceArray",serviceArray);
//        return resultMap;
//    }
    @RequestMapping("/getServiceByKeyword")
    public @ResponseBody Map<String,Object> getServiceByKeyword(HttpServletRequest request){
        String strPage=request.getParameter("pageNow");
        int pageNow=Integer.parseInt(strPage);
        String keyword=request.getParameter("keyword");
        List<ServiceResult> serviceArray=orderService.getServiceByKeyword(pageNow,keyword);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("serviceArray",serviceArray);
        return resultMap;
    }

    @RequestMapping("/getServiceByServiceId")
    public @ResponseBody Map<String,Object> getServiceByServiceId(HttpServletRequest request){
        String strServiceId=request.getParameter("serviceId");
        int serviceId=Integer.parseInt(strServiceId);
        String content=orderService.getServiceByServiceId(serviceId);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("content",content);
        return resultMap;
    }

    @RequestMapping("/publishService")
    public @ResponseBody NetResult publishService(HttpServletRequest request){
        String content=request.getParameter("content");
        String strPrice=request.getParameter("price");
        int price=Integer.parseInt(strPrice);
        String strLowDeadline=request.getParameter("lowDeadline");
        System.out.println(strLowDeadline);
        Timestamp lowDeadline=Timestamp.valueOf(strLowDeadline);
        String strHighDeadline=request.getParameter("highDeadline");
        Timestamp highDeadline=Timestamp.valueOf(strHighDeadline);
        String strPlaceId=request.getParameter("placeId");
        int placeId=Integer.parseInt(strPlaceId);
        String strTypeId=request.getParameter("typeId");
        int typeId=Integer.parseInt(strTypeId);
        String token=request.getHeader("token");
        int servantId=userService.getUserIdByToken(token);
        String title=StrUtil.cutStr(content,32);
        NetResult netResult=orderService.addService(servantId,typeId,placeId,price,lowDeadline,highDeadline,title,content);
        return netResult;
    }



}
