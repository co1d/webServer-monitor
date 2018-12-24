package com.zplus.controller;

import com.zplus.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
public class RedisController
{
    @Autowired
    private AsyncService asyncService;
    
    public String save(String url) throws Exception
    {
        //CompletableFuture<String> future=asyncService.httpGetRequest(url);
        //CompletableFuture.allOf(future).join();
        //return future.get();
        return "";
    }
    
    public void test3(List<String> l) throws Exception
    {
        Map<String,String> map=new HashMap<>();
        for(String str:l)
        {
            map.put(str,save(str));
        }
        
    }
   
}