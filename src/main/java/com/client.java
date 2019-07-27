package com;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.List;

public class client {
    private static final String baseUrl = "http://weixiao.nickboy.cc/wall/content/gh_ad270e337f93?vid=c219ea379b39e6562b8f1971e07a6683&openid=qq_F6DF67DD29B020DAF5026A5EA984F680&page=";
    private static final String sql = "INSERT INTO `test`.`biaobaiqiang` (`cid`, `content`, `good`, `nickname`, `picurl`, `time`, `r_count`, `id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public static void main(String[] args) {
        //共有112页
        /*Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=60;++i){
                    p(i);
                }
            }
        });
        thread.start();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=61;i<=112;++i){
                    p(i);
                }
            }
        });
        thread1.start();*/
        p(1);
    }
    private synchronized static void p(int page){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(baseUrl+page);
        System.out.println("========正在爬取第"+page+"个页面========");
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(10000)
                .setSocketTimeout(20000)
                .build();
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
        }catch (Exception e){

        }
        HttpEntity entity = response.getEntity();
        String res = null;
        try{
            res = EntityUtils.toString(entity,"utf-8");
        }catch (Exception e){

        }
        List<Mode> modes = JSONArray.parseArray(res, Mode.class);
        insert1(modes.get(1));

    }
    //INSERT INTO `test`.`biaobaiqiang` (`cid`, `content`, `good`, `nickname`, `picurl`, `time`, `r_count`, `id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)
    private synchronized static void insert(List<Mode> modes){
        for(Mode m : modes){
            Object params[]={
                    m.getCid(),
                    m.getContent(),
                    m.getGood(),
                    m.getNickname(),
                    m.getPicurl(),
                    m.getTime(),
                    m.getR_count(),
                    m.getId()
            };
            C3P0Utils.update(sql,params);
        }
    }
    private synchronized static void insert1(Mode m){
            Object params[]= {
                    m.getCid(),
                    m.getContent(),
                    m.getGood(),
                    m.getNickname(),
                    m.getPicurl(),
                    m.getTime(),
                    m.getR_count(),
                    m.getId()
            };
            C3P0Utils.update(sql,params);
        }
}

