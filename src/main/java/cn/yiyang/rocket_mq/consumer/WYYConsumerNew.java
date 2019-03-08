package cn.yiyang.rocket_mq.consumer;

import com.maihaoche.starter.mq.annotation.MQConsumer;
import com.maihaoche.starter.mq.base.AbstractMQPushConsumer;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @ClassName WYYConsumer
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/20 11:29
 * @Version 1.0
 * 一个新的消费者，用于处理topic为wangyiyangnew
 **/
@MQConsumer(topic = "wangyiyangnew", consumerGroup = "local_sucloger_dev_new")
@Slf4j
public class WYYConsumerNew extends AbstractMQPushConsumer {
    @Override
    public boolean process(Object o, Map map) {
        System.out.println("wangyiyangnew");
        log.info(o.toString());
        return true;
    }
}
