package cn.ikangjia.fun.mysql.api.vo;

import cn.ikangjia.fun.mysql.entity.DataSourceDO;
import lombok.Data;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/10/5 10:11
 */
@Data
public class DataSourceVO {
    private List<DataSourceDO> dataSourceDOList;
    private Long total;
}
