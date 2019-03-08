package cn.yiyang.demo.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName DemoEntity
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/8 16:59
 * @Version 1.0
 **/
@Data
@Builder
public class DemoEntity {
    private String name;
    private String age;
}
