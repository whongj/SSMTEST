package com.wdsznb.books.services.imp;

import com.wdsznb.books.clients.client.SSLHttpClient;
import com.wdsznb.books.services.HttpClientService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;


import java.util.Map;

/**
 * Created by Tyranitarx on 2017/5/2.
 */
@Service("BookDetailClinetService")
public class BookDetailClientService implements HttpClientService{
    @Override
    public Map<String,String> doPost(String isbn,String charset){
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        Map resultmap=null;
        try {
            //利用httpClient发送https请求
            httpClient = new SSLHttpClient().registerSSL("0","TLS",443,"https");
            httpPost = new HttpPost("https://api.douban.com/v2/book/isbn/"+isbn);
            HttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    //jackson的ObjectMapper将返回的jsonString转换为Map
                    result = EntityUtils.toString(resEntity, charset);
                    ObjectMapper mapper=new ObjectMapper();
                    resultmap=mapper.readValue(result,Map.class);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultmap;

    }
}