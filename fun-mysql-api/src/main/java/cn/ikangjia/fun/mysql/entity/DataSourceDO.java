package cn.ikangjia.fun.mysql.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/9/28 12:37
 */
@Data
@TableName("t_datasource")
public class DataSourceDO {
    private Long id;
    private String name;
}
