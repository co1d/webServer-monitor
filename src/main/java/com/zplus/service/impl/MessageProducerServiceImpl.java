package com.zplus.service.impl;

import com.zplus.service.MessageProducerService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Queue;
import java.util.*;

@Service
public class MessageProducerServiceImpl implements MessageProducerService
{
    @Resource
    private JmsTemplate jmsTemplate;
    
    @Resource
    private Queue queue;
    
    @Override
    public void sendMessage(List<?> httpGetRequest)
    {
        this.jmsTemplate.convertAndSend(this.queue,httpGetRequest);
    }
}