package cn.yiyang.mysqldemo.service.impl;

import cn.yiyang.mysqldemo.entity.DemoTestEntity;
import cn.yiyang.mysqldemo.mapper.DemoTestMapper;
import cn.yiyang.mysqldemo.service.DemoTestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangyiyang
 * @since 2019-02-19
 */
@Service
public class DemoTestServiceImpl extends ServiceImpl<DemoTestMapper, DemoTestEntity> implements DemoTestService {

}
