package com.zplus.controller;

import com.zplus.entity.IURL;
import com.zplus.service.AsyncService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

@Controller
//jar包中用file:config.properties
@PropertySource(value = {"classpath:config.properties"})
public class AsyncController
{
    @Autowired
    private AsyncService asyncService;
    
    //读取properites中配置的url list
    @Value("${web.server.urlList}")
    private List<String> urlList=new ArrayList<>();
    
    //添加自定义线程池
    @Autowired
    @Qualifier(value = "getAsyncExecutor")
    private Executor executor;
    
    public List<?> doAsyncServiceHttpGet() throws Exception
    {
        List<IURL> list=setIURL();
        return list.stream().map(a -> CompletableFuture.supplyAsync(() -> {
            Map<String,String> map=new HashMap<>();
            map.put(a.getUrl(),a.doHttpGet(a.getUrl()));
            return map;
        },executor)).collect(Collectors.toList()).stream().map(CompletableFuture::join).collect(Collectors.toList());
    }
    
    private List<IURL> setIURL()
    {
        List<IURL> list=new ArrayList<>();
        for(String s:urlList)
            list.add(new IURL(s));
        return list;
    }
    
}