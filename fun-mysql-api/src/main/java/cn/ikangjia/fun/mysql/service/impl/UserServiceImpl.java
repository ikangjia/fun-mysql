package cn.ikangjia.fun.mysql.service.impl;

import cn.ikangjia.fun.mysql.entity.UserDO;
import cn.ikangjia.fun.mysql.mapper.UserMapper;
import cn.ikangjia.fun.mysql.service.UserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/10/8 9:10
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDO getUser(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public String doLogin(UserDO userDO) {
        LambdaQueryWrapper<UserDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserDO::getAccount, userDO.getAccount())
                .eq(UserDO::getPassword, userDO.getPassword());
        List<UserDO> userDOList = userMapper.selectList(wrapper);
        if (userDOList == null || userDOList.size() < 1) {
            // 用户名或密码错误
            throw new RuntimeException("用户名或密码错误！");
        } else if (userDOList.size() > 1) {
            throw new RuntimeException("内部错误！可能是用户名重复，请联系管理员！");
        }
        UserDO userDetail = userDOList.get(0);
        return JWT.create().withAudience(String.valueOf(userDetail.getId()))
                .withExpiresAt(LocalDateTime.now().plusMinutes(120L).toInstant(ZoneOffset.UTC))
                .sign(Algorithm.HMAC256(userDetail.getPassword()));
    }
}
