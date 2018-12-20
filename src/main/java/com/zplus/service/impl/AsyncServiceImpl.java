package com.zplus.service.impl;

import com.zplus.utils.HttpClientUtils;
import com.zplus.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncServiceImpl implements AsyncService
{
    @Override
    @Async
    public CompletableFuture<String> httpGetRequest(String url)
    {
        return CompletableFuture.completedFuture(HttpClientUtils.doGet(url));
    }
}