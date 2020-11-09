package com.denis.zhong.world.util.http;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class HttpUtil {

    /***
     * 返回的结果默认json格式
     * @param cls
     * @param param
     * @param url
     * @param headers
     * @param <T>
     * @return
     */
    public static <T> T get(Class<T> cls, Map<String,String> param,String url,Map<String,String> headers){
        CloseableHttpClient client = HttpClients.custom()
                .setKeepAliveStrategy(new CustomizedKeepAliveStrategy())
                .setRetryHandler(new CustomizedRetryHandler())
                .build();
        StringBuilder paramBuilder = new StringBuilder();
        paramBuilder.append(url).append("?");
        HttpUriRequest request = new HttpGet();
        if (param != null) {
            for (String key : param.keySet()) {
                paramBuilder.append(key + "=" + param.get(key));
                paramBuilder.append("&");
            }
            if (paramBuilder.length() > 0)
                paramBuilder.deleteCharAt(paramBuilder.length()-1);
        }
        if (headers != null) {
            for (String key : headers.keySet()) {
                request.addHeader(key, headers.get(key));
            }
        }
        ((HttpGet) request).setURI(URI.create(paramBuilder.toString()));
        try (CloseableHttpResponse response = client.execute(request)) {
           if(HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
               // 缓存可多次使用
               return JSONObject.parseObject(readHttpEntity(response.getEntity()),cls);
           }
        }catch (IOException exception){
            log.error("httpGet request occur error,the param is:{}",paramBuilder);
        }
        return null;
    }

    private static String readHttpEntity(HttpEntity httpEntity) throws IOException{
        if(Objects.nonNull(httpEntity)){
            BufferedHttpEntity entity = new BufferedHttpEntity(httpEntity);
            Charset charset =  ContentType.getOrDefault(entity).getCharset();
            if(Objects.isNull(charset)){
                charset = Charset.defaultCharset();
            }
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(entity.getContent(),charset));
            StringBuffer resultStr = new StringBuffer();
            char[] buffer = new char[2048];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                resultStr.append(new String(buffer, 0, length));
            }
            return resultStr.toString();
        }
        return null;
    }

    /***
     * post 请求，
     * 不支持FileEntity、UrlEncodeformedEntify gzip
     * 返回默认json
     * @param cls
     * @param jsonStrEntity
     * @param headers
     * @param url
     * @param <T>
     * @return
     */
    public <T> T post(Class<T> cls,String jsonStrEntity,Map<String,String> headers,String url){
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpUriRequest request = new HttpPost(URI.create(url));
        if (headers != null) {
            for (String key : headers.keySet()) {
                request.addHeader(key, headers.get(key));
            }
        }
        if(!StringUtils.isEmpty(jsonStrEntity)){
                try (CloseableHttpResponse response = httpClient.execute(request)) {
                    HttpEntity entity = new StringEntity(jsonStrEntity,Charset.defaultCharset().displayName());
                    ((BasicHttpEntity) entity).setContentType("application/json");
                    ((HttpPost) request).setEntity(entity);
                    StatusLine statusLine = response.getStatusLine();
                    if(Objects.nonNull(statusLine) && HttpStatus.SC_OK == statusLine.getStatusCode()){
                        if(Objects.nonNull(response.getEntity())){
                         return JSONObject.parseObject(readHttpEntity(response.getEntity()),cls);
                        }
                    }
                }catch (IOException exception){
                    log.error("post request occur error, param:{},url:{}",jsonStrEntity,url);
                }
        }
        return null;
    }

}
