package com.wdsznb.books.services.imp;

import com.wdsznb.books.clients.client.AbsRestClient;
import com.wdsznb.books.clients.client.JsonReqClient;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Tyranitarx on 2017/4/27.
 */
@Service("MessageValidateService")
public class MessageValidateService {
    public Map<String,String> testTemplateSMS(boolean json, String accountSid, String authToken, String appId, String templateId, String to, String param) {
            try {
                //利用jackson的ObjectMapper将返回的jsonString转换为map
                ObjectMapper mapper=new ObjectMapper();
                Map<String,String> resultmap;
                String result = new JsonReqClient().templateSMS(accountSid, authToken, appId, templateId, to, param);
                resultmap=mapper.readValue(result,Map.class);
                return resultmap;
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            return null;
        }

}
