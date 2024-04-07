//package com.garment.web.controller.listener;
//
//import com.garment.common.core.redis.RedisCache;
//import com.rabbitmq.client.Channel;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.Map;
//
///**
// * @Author leedan
// * @Description : 消息接收者
// * @Date 2023/11/20  13:47
// * @Version 1.0
// */
//@Component
//public class DirectReceiverListener {
//    @Autowired
//    private RedisCache redisCache;
//
//    @RabbitListener(queues = "sdQuee")
//    public void process(Map map, Channel channel, Message message) {
//        long deliveryTag = message.getMessageProperties().getDeliveryTag();
//        try {
//            String mes = new String(message.getBody(), "UTF-8");
//            channel.basicQos(1);
//            System.out.println("通道1获取到任务");
//            Thread.sleep(50000l);
//            System.out.println("通道1获取消费结束");
//            //手动ack  第二个参数为false是表示仅仅确认当前消息 true表示确认之前所有的消息
////            channel.basicNack(deliveryTag,false,true);
//            channel.basicAck(deliveryTag,false);
//
////            redisCache.set
//        }
//        catch (Exception e){
//            try {
//                //手动nack 告诉rabbitmq该消息消费失败  第三个参数：如果被拒绝的消息应该被重新请求，而不是被丢弃或变成死信，则为true
//                channel.basicNack(deliveryTag,false,true);
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
//
//    /**
//     * 配置多台数据
//     *
//     *@Author leedan
//     *@Description
//     *@Date 2023/11/20
//     *@param map
//     *@param channel
//     *@param message
//     *@return void
//     *@throws
//     */
//    @RabbitListener(queues = "sdQuee")
//    public void process1(Map map, Channel channel, Message message) {
//        long deliveryTag = message.getMessageProperties().getDeliveryTag();
//        try {
//            channel.basicQos(1);
//            String mes = new String(message.getBody(), "UTF-8");
//            System.out.println("通道2获取到任务");
//            Thread.sleep(100000l);
//            System.out.println("通道2获取消费结束");
//            //手动ack  第二个参数为false是表示仅仅确认当前消息 true表示确认之前所有的消息
////            channel.basicNack(deliveryTag,false,true);
//            channel.basicAck(deliveryTag,false);
////            redisCache.set
//        }
//        catch (Exception e){
//            try {
//                //手动nack 告诉rabbitmq该消息消费失败  第三个参数：如果被拒绝的消息应该被重新请求，而不是被丢弃或变成死信，则为true
//                channel.basicNack(deliveryTag,false,true);
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
//
//}
