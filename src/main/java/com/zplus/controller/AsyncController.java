package com.zplus.controller;

import com.zplus.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.concurrent.CompletableFuture;

@Controller
public class AsyncController
{
    @Autowired
    private AsyncService asyncService;
    
    public String httpRequest(String url) throws Exception
    {
        CompletableFuture<String> future=asyncService.httpGetRequest(url);
        CompletableFuture.allOf(future).join();
        return future.get();
    }
}