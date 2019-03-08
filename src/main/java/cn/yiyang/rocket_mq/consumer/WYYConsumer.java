package cn.yiyang.rocket_mq.consumer;

import cn.yiyang.rocket_mq.producer.WYYProducer;
import com.maihaoche.starter.mq.annotation.MQConsumer;
import com.maihaoche.starter.mq.base.AbstractMQPushConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @ClassName WYYConsumer
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/20 11:29
 * @Version 1.0
 **/
@MQConsumer(topic = "wyy_producer", consumerGroup = "wyy_consumer_group")
@Slf4j
public class WYYConsumer extends AbstractMQPushConsumer {



    @Override
    public boolean process(Object o, Map map) {
        try {
            System.out.println("wangyiyang");
            Thread.sleep(1000);
            log.info(o.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Message build = MessageBuilder.of(o).topic("wangyiyang").build();
//        wyyProducer.syncSend(build);
        return true;
    }
}
