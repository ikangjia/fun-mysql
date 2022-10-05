package cn.ikangjia.fun.mysql.service;

import cn.ikangjia.fun.mysql.api.query.PageQuery;
import cn.ikangjia.fun.mysql.api.vo.DataSourceVO;
import cn.ikangjia.fun.mysql.entity.DataSourceDO;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/10/5 09:56
 */
public interface DataSourceService {

    DataSourceDO getDataSource(Long dataSourceId);

    DataSourceVO listDataSource(PageQuery pageQuery);

    Boolean updateDataSource(DataSourceDO dataSourceDO);

    Boolean removeDataSource(Long dataSourceId);

    Boolean removeDataSourceBatch(List<Long> dataSourceIdList);

    Boolean saveDataSource(DataSourceDO dataSourceDO);

    /**
     * 测试 MySQL 数据源的连通性
     *
     * @param dataSourceDO 数据源信息
     * @return 测试结果
     */
    Boolean testConnection(DataSourceDO dataSourceDO);

}
