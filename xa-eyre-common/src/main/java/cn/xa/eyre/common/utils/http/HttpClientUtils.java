package cn.xa.eyre.common.utils.http;

import cn.xa.eyre.common.constant.Constants;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 通用http发送方法
 * 
 * @author ruoyi
 */
public class HttpClientUtils
{
    private static final Logger log = LoggerFactory.getLogger(HttpClientUtils.class);



    public static String commDataRequest(String url,String data)throws ClientProtocolException,ParseException,IOException{
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        httpClient = HttpClients.createDefault();
        /*RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(5000).build();
        httpPost.setConfig(requestConfig);*/
        HttpEntity entity = new StringEntity(data,Consts.UTF_8);
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.setEntity(entity);
        try {
            response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity(),Charset.forName("UTF-8"));
        }finally {
            if(response != null){
                response.close();
            }
            if(httpClient != null){
                httpClient.close();
            }
        }
    }

    /**
     * 向指定地址发送post请求
     * @param url http请求地址
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    public static String sendHttpClientPost(String url, String param)throws ClientProtocolException, ParseException,IOException
    {
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        httpClient = HttpClients.createDefault();
        HttpEntity entity = new StringEntity(param, Consts.UTF_8);
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.setEntity(entity);
        try {
            response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
        }finally {
            if(response != null){
                response.close();
            }
            if(httpClient != null){
                httpClient.close();
            }
        }
    }

    /**
     * 向指定地址发送delete请求
     * @param url http请求地址
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    public static String sendHttpClientDelete(String url, String param)throws ParseException,IOException
    {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpDeleteWithBody delete = new HttpDeleteWithBody(url);
        delete.setEntity(new StringEntity(param, "application/json", "UTF-8"));
        // 添加请求头
        delete.setHeader("Content-Type", "application/json");
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(delete);
            return EntityUtils.toString(response.getEntity(), Charset.forName("UTF-8"));
        }finally {
            if(response != null){
                response.close();
            }
            if(httpClient != null){
                httpClient.close();
            }
        }
    }

    public static String sendHttpRequest(String url, String param, String method) throws IOException {
        if (method.equals(Constants.HTTP_METHOD_POST)){
            return sendHttpClientPost(url, param);
        }else {
            return sendHttpClientDelete(url, param);
        }
    }

}