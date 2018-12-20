package com.zplus.service;

import java.util.concurrent.CompletableFuture;

public interface AsyncService
{
    CompletableFuture<String> httpGetRequest(String url);
}
