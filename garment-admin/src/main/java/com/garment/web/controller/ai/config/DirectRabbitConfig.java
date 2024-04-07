//package com.garment.web.controller.ai.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.connection.CorrelationData;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
///**
// * @Author leedan
// * @Description :
// * @Date 2023/11/20  13:36
// * @Version 1.0
// */
//@Configuration
//public class DirectRabbitConfig implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback{
//
//    private static final Logger log = LoggerFactory.getLogger(DirectRabbitConfig.class);
//    //队列 起名：TestDirectQueue
//    @Bean
//    public Queue TestDirectQueue() {
//        // durable: 是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
//        // exclusive: 默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。
//        // autoDelete: 是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
//        //一般设置一下队列的持久化就好,其余两个就是默认false
//        Map<String, Object> args = new HashMap<>();
//        // 队列设置最大长度
//        args.put("x-max-length", 100000);
////        return new Queue("normalQueue", true, false, false, args);
//
//        return new Queue("sdQuee",true, false, false, args);
//    }
//
//    @Bean
//    public Queue sdQuee() {
//        // durable: 是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
//        // exclusive: 默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。
//        // autoDelete: 是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
//        //一般设置一下队列的持久化就好,其余两个就是默认false
//        Map<String, Object> args = new HashMap<>();
//        // 队列设置最大长度
//        args.put("x-max-length", 100000);
////        return new Queue("normalQueue", true, false, false, args);
//
//        return new Queue("sdQuee",true, false, false, args);
//    }
//
//
//    //Direct交换机 起名：TestDirectExchange
//    @Bean
//    DirectExchange TestDirectExchange() {
//        //  return new DirectExchange("TestDirectExchange",true,true);
//        return new DirectExchange("TestDirectExchange",true,false);
//    }
//
//    //绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
//    @Bean
//    Binding bindingDirect() {
//
//        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("TestDirectRouting");
//    }
//
//
//
//    @Bean
//    DirectExchange lonelyDirectExchange() {
//        return new DirectExchange("lonelyDirectExchange");
//    }
//
//    /**
//     *
//     *
//     *@Author leedan
//     *@Description
//     *@Date 2023/11/20
//     *@param correlationData
//     *@param ack
//     *@param cause
//     *@return void
//     *@throws
//     */
//    @Override
//    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//        if (ack) {
//            log.info("交换机收到消息成功：" + correlationData.getId());
//        }else {
//            log.error("交换机收到消息失败：" + correlationData.getId() + "原因：" + cause);
//        }
//    }
//
//    /**
//     *
//     *
//     *@Author leedan
//     *@Description
//     *@Date 2023/11/20
//     *@param returnedMessage
//     *@return void
//     *@throws
//     */
//    @Override
//    public void returnedMessage(ReturnedMessage returnedMessage) {
//        log.error("{}--消息未成功到达队列",returnedMessage.getMessage().getMessageProperties().getMessageId());
//    }
//}
