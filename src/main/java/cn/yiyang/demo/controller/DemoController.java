package cn.yiyang.demo.controller;

import cn.yiyang.common.utils.ResultBean;
import cn.yiyang.demo.entity.DemoEntity;
import cn.yiyang.rocket_mq.producer.WYYProducer;
import com.maihaoche.starter.mq.base.MessageBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DemoController
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/8 16:37
 * @Version 1.0
 **/
@RestController
@Slf4j
public class DemoController {

    @Autowired
    private WYYProducer wyyProducer;

    @PostMapping("/reocketProducter")
    public ResultBean reocketProducter() {
        DemoEntity e = DemoEntity.builder().name("王一扬").age("27").build();
        Message message = MessageBuilder.of(e).topic("wyy_producer").build();
        log.info(wyyProducer.toString());
        wyyProducer.syncSend(message);
        return ResultBean.success();
    }

}
