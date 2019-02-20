package cn.yiyang.mysqldemo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangyiyang
 * @since 2019-02-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("demo_test")
public class DemoTestEntity extends Model<DemoTestEntity> {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;
    @TableField("ban")
    private Integer ban;
    @TableField("my_bigint")
    private Long myBigint;
    @TableField("my_int")
    private Integer myInt;
    @TableField("my_datetime")
    private Date myDatetime;
    @TableField("my_timestamp")
    private Date myTimestamp;
    @TableField("my_double")
    private Double myDouble;
    @TableField("my_decmial")
    private BigDecimal myDecmial;
    @TableField("my_char")
    private String myChar;
    @TableField("my_varchar")
    private String myVarchar;
    @TableField("my_enum")
    private String myEnum;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
