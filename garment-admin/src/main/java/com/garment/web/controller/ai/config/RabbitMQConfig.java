//package com.garment.web.controller.ai.config;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RabbitMQConfig {
//
//    @Bean
//    public SimpleMessageListenerContainer messageListenerContainer(
//            ConnectionFactory connectionFactory, CustomMessageListener customMessageListener) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames("sdQuee"); // 设置监听的队列名
//        container.setMessageListener(customMessageListener);
////        container.s
//        return container;
//    }
//
//
//}
