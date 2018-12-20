package com.zplus.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.*;

import javax.jms.Queue;

@Configuration
//@PropertySource(value = {"file:config.properties"})
@EnableJms
public class ActiveMQConfig
{
    //@Value("${activemq.broker.url}")
    String broker_url="tcp://test4.ihzsr.cn:61616";

    //@Value("${activemq.user}")
    String username="admin";

    //@Value("${activemq.password}")
    String password="admin";

    //@Value("${activemq.queue.name}")
    String queueName;
    /*
     * Initial ConnectionFactory
     */
    @Bean
    public ActiveMQConnectionFactory connectionFactory()
    {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(broker_url);
        connectionFactory.setUserName(username);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }
    
    @Bean
    public Queue queue()
    {
        return new ActiveMQQueue("http.request.queue");
    }

    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter() 
    {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
    
    @Bean
    public JmsTemplate jmsTemplate ()
    {
        JmsTemplate jmsTemplate =new JmsTemplate();
        jmsTemplate.setMessageConverter(jacksonJmsMessageConverter());
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setDeliveryMode(2);
        return jmsTemplate;
    }
}
