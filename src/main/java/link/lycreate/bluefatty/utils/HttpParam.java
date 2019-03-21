package link.lycreate.bluefatty.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @ClassName HttpParam
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/3/21 17:54
 */
public class HttpParam {
    /**
     * description
     * @author LYcreate
     * @date 2019/3/21 22:44
     * @param url
    param
     * @return java.lang.String
     */
    public static String sendGet(String url, String param) {
        String urlParam=url+"?"+param;
        String result=null;
        // 创建httpClient实例对象
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet=new HttpGet(urlParam);
        CloseableHttpResponse response=null;
        try{
            response=httpClient.execute(httpGet);
            RequestConfig config=RequestConfig.custom()
                    .setConnectTimeout(5000)
                    .setConnectionRequestTimeout(5000)
                    .setSocketTimeout(5000).build();
            httpGet.setConfig(config);
            HttpEntity entity=response.getEntity();
            result=EntityUtils.toString(entity);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


}
