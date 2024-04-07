//package com.garment.web.controller.ai.config;
//
//import org.springframework.amqp.core.Message;
//import com.rabbitmq.client.Channel;
//import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CustomMessageListener implements ChannelAwareMessageListener {
//
//    @Override
//    public void onMessage(Message message, Channel channel) throws Exception {
//        // 处理接收到的消息逻辑
//        System.out.println("Received message: " + new String(message.getBody()));
//
//        // 手动确认消息
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//    }
//}
