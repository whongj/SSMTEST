package com.wdsznb.books.services.imp;

import com.wdsznb.books.clients.client.SSLHttpClient;
import com.wdsznb.books.services.HttpClientService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.Map;

/**
 * Created by Tyranitarx on 2017/5/9.
 */
public class getAccessTokenService extends Thread implements HttpClientService {
    private String accesstoken;
    @Override
    public Map<String,String> doPost(String url,String charset){
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        Map resultmap=null;
        try {
            //利用httpClient发送https请求
            httpClient = new SSLHttpClient().registerSSL("0","TLS",443,"https");
            httpPost = new HttpPost("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxf5e53f9271098f64&secret=60a3cf7b8028cdac9b03cdaf4634c9f5");
            HttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    //jackson的ObjectMapper将返回的jsonString转换为Map
                    result = EntityUtils.toString(resEntity, charset);
                    ObjectMapper mapper=new ObjectMapper();
                    resultmap=mapper.readValue(result,Map.class);
                    accesstoken=(String)resultmap.get("access_token");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultmap;

    }
}
