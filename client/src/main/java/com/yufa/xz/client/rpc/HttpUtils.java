package com.yufa.xz.client.rpc;

import com.alibaba.fastjson.JSON;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ly
 * @data 2020/7/30
 */
public class HttpUtils {

    public static synchronized Result callRemoteService(String identifier, String methodName,
                                                        String argTypes, String argValues){

        String url = "http://127.0.0.1:15012";

        List<NameValuePair> paramsList = new ArrayList<>();
        paramsList.add(new BasicNameValuePair("identifier",identifier));
        paramsList.add(new BasicNameValuePair("methodName",methodName));
        paramsList.add(new BasicNameValuePair("argTypes",argTypes));
        paramsList.add(new BasicNameValuePair("argValues",argValues));
        try {
            String result = sendPost(url, paramsList);
            return JSON.parseObject(result, Result.class);
        } catch (IOException e) {
           return Result.getFailResult("远程调用失败");
        }
    }

    private static String sendPost(String url, List<NameValuePair> paramsList) throws IOException {

        CloseableHttpResponse response = null;
        int successCode = 200;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        try {
            StringEntity entity = new UrlEncodedFormEntity(paramsList, "UTF-8");
            httpPost.setEntity(entity);
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (successCode == statusCode){
                return EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null){
                response.close();
            }
        }
        return null;
    }

}
