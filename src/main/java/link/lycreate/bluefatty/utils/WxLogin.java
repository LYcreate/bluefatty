package link.lycreate.bluefatty.utils;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * @ClassName WxLogin
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/3/21 17:20
 */
public class WxLogin {
    private static final String appSecrect="1e37e9e1310e18058fdb410b5a5d77cb";
    private static final String appId="wx81e4fb1930bb84c8";
    private static final String url="https://api.weixin.qq.com/sns/jscode2session";
    /**
     * description
     * @author LYcreate
     * @date 2019/3/21 17:45
     * @param code
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public static Map<String,Object> getUserInfo(String code){
        String parameter="appid="+appId+"&secret="+appSecrect+"&js_code="+code+"&grant_type=authorization_code";
        String resultStr=HttpParam.sendGet(url,parameter);
        System.out.println("result:"+resultStr);
        Map<String,Object> resultMap=(Map)JSON.parse(resultStr);
        return resultMap;
    }
}
