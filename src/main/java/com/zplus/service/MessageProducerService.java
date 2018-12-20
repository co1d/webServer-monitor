package com.zplus.service;

import java.util.List;

public interface MessageProducerService
{
    void sendMessage(List<String> httpGetRequest) throws Exception;
}
