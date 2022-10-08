package cn.ikangjia.fun.mysql.mapper;

import cn.ikangjia.fun.mysql.entity.UserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/10/8 9:06
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
