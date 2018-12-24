package com.zplus;

import com.zplus.controller.AsyncController;
import com.zplus.service.MessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableCaching
@EnableScheduling
//@MapperScan("com.zplus.repository")
public class Application implements CommandLineRunner
{
    @Autowired
    private AsyncController asyncController;
    
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
        //sendToMQ();
        //RedisServiceImpl controller=new RedisServiceImpl();
        //controller.tet();

        //UserServiceImpl userService=new UserServiceImpl();
        //userService.getById(5L);
    }
    
    @Scheduled(cron = "${task.schedule}")
    public void sendToMQ() throws Exception
    {
        producerService.sendMessage(asyncController.doAsyncServiceHttpGet());
    }
}