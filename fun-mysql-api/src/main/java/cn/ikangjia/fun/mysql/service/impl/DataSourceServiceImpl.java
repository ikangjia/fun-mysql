package cn.ikangjia.fun.mysql.service.impl;

import cn.ikangjia.fun.mysql.api.query.PageQuery;
import cn.ikangjia.fun.mysql.api.vo.DataSourceVO;
import cn.ikangjia.fun.mysql.core.DataSourceUtil;
import cn.ikangjia.fun.mysql.entity.DataSourceDO;
import cn.ikangjia.fun.mysql.mapper.DataSourceMapper;
import cn.ikangjia.fun.mysql.service.DataSourceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/10/5 09:57
 */
@Service
public class DataSourceServiceImpl implements DataSourceService {
    private final DataSourceMapper dataSourceMapper;

    public DataSourceServiceImpl(DataSourceMapper dataSourceMapper) {
        this.dataSourceMapper = dataSourceMapper;
    }

    @Override
    public DataSourceDO getDataSource(Long dataSourceId) {
        return dataSourceMapper.selectById(dataSourceId);
    }

    @Override
    public DataSourceVO listDataSource(PageQuery pageQuery) {
        IPage<DataSourceDO> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        QueryWrapper<DataSourceDO> wrapper = new QueryWrapper<>();

        if (StringUtils.hasText(pageQuery.getKeyword())) {
            wrapper.like("name", pageQuery.getKeyword());
        }
        IPage<DataSourceDO> selectPage = dataSourceMapper.selectPage(page, wrapper);

        DataSourceVO result = new DataSourceVO();
        result.setDataSourceDOList(selectPage.getRecords());
        result.setTotal(dataSourceMapper.selectCount(null));
        return result;
    }

    @Override
    public Boolean updateDataSource(DataSourceDO dataSourceDO) {
        return dataSourceMapper.updateById(dataSourceDO) == 1;
    }

    @Override
    public Boolean removeDataSource(Long dataSourceId) {
        return dataSourceMapper.deleteById(dataSourceId) == 1;
    }

    @Override
    public Boolean removeDataSourceBatch(List<Long> dataSourceIdList) {
        dataSourceMapper.deleteBatchIds(dataSourceIdList);
        return true;
    }

    @Override
    public Boolean saveDataSource(DataSourceDO dataSourceDO) {
        dataSourceMapper.insert(dataSourceDO);
        return true;
    }

    @Override
    public Boolean testConnection(DataSourceDO dataSourceDO) {
        Long id = dataSourceDO.getId();
        DataSourceDO sourceDO = dataSourceMapper.selectById(1L);
        return DataSourceUtil.testConnection(sourceDO);
    }
}
