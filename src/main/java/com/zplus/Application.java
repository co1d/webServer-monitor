package com.zplus;

import com.zplus.controller.AsyncController;
import com.zplus.service.MessageProducerService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.*;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableCaching
@MapperScan("com.zplus.repository")
public class Application implements CommandLineRunner
{
    @Autowired
    private AsyncController controller;
    
    @Autowired
    private MessageProducerService producerService;
    
    public static void main( String[] args )
    {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }
    
    @Override
    public void run(String... args) throws Exception
    {
        List<String> urlList=new ArrayList<>();
        urlList.add("http://srsm.ihzsr.cn/sql/message");
        urlList.add("http://www.baidu.com");
        urlList.add("http://srsm.ihzsr.cn/sql/message");
        urlList.add("http://srsm.ihzsr.cn/sql/message");
        urlList.add("http://srsm.ihzsr.cn/sql/message");
        //producerService.sendMessage(doHttpGet(urlList));
    }
    
    public List<String> doHttpGet(List<String> url) throws Exception
    {
        List<String> result=new ArrayList<>();
        for(String v:url)
            result.add(controller.httpRequest(v));
        return result;
    }
}