package cn.yiyang.mysqldemo.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.yiyang.common.producer.WYYProducer;
import cn.yiyang.common.utils.ResultBean;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.maihaoche.starter.mq.base.MessageBuilder;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import cn.yiyang.mysqldemo.service.DemoTestService;
import cn.yiyang.mysqldemo.entity.DemoTestEntity;
import java.util.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangyiyang
 * @since 2019-02-19
 */
@RestController
@RequestMapping("/mysqldemo/demoTestEntity")
public class DemoTestController {


    @Autowired
    private DemoTestService demoTestService;

    @Autowired
    private WYYProducer wyyProducer;
    /**
    * 新增
    */
    @PostMapping("/save")
    public ResultBean save(){
        //构建消息发送体
        for (int i = 0; i < 100000; i++) {
            DemoTestEntity entity = new DemoTestEntity();
            entity.setBan(0).setId(IdUtil.fastSimpleUUID()).setMyDatetime(DateUtil.date()).setMyVarchar(Integer.toString(i));
            Message msg = MessageBuilder.of(entity).topic("wangyiyang").build();
            wyyProducer.syncSend(msg);
        }
        return ResultBean.success();
    }

    /**
    * 通过id删除
    */
    @DeleteMapping
    public boolean delete(DemoTestEntity demoTestEntity){
        return demoTestService.removeById(demoTestEntity);
    }

    /**
    * 修改
    */
    @PutMapping
    public boolean updateById(DemoTestEntity demoTestEntity){
        return demoTestService.updateById(demoTestEntity);
    }


    /**
    * 查询列表
    */
    @GetMapping("/list")
    public List<DemoTestEntity> list(DemoTestEntity demoTestEntity ){
        QueryWrapper<DemoTestEntity> wp = new QueryWrapper<>();
        //todo init wp
        return demoTestService.list(wp);
    }

    /**
    * 分页查询
    */
    @GetMapping("/page")
    public IPage<DemoTestEntity> page(Page<DemoTestEntity> page,DemoTestEntity demoTestEntity){
        QueryWrapper<DemoTestEntity> wp = new QueryWrapper<>();
        //todo init wp
        return demoTestService.page(page,wp);
    }


}

