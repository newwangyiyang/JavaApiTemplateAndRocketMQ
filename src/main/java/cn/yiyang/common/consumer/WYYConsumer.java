package cn.yiyang.common.consumer;

import cn.yiyang.common.producer.WYYProducer;
import cn.yiyang.common.utils.MessageUtils;
import com.maihaoche.starter.mq.annotation.MQConsumer;
import com.maihaoche.starter.mq.base.AbstractMQPushConsumer;
import com.maihaoche.starter.mq.base.MessageBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Timer;

/**
 * @ClassName WYYConsumer
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/20 11:29
 * @Version 1.0
 **/
@MQConsumer(topic = "wangyiyang", consumerGroup = "local_sucloger_dev")
@Slf4j
public class WYYConsumer extends AbstractMQPushConsumer {

    @Autowired
    private WYYProducer wyyProducer;

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
