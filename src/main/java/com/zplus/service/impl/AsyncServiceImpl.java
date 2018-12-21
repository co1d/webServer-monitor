package com.zplus.service.impl;

import com.zplus.service.AsyncService;
import com.zplus.utils.HttpClientUtils;
import org.springframework.stereotype.Service;

@Service
public class AsyncServiceImpl implements AsyncService
{
    @Override
    //@Async
    public String httpGetRequest(String url)
    {
        return HttpClientUtils.doGet(url);
    }
}