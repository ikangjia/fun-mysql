package cn.ikangjia.fun.mysql.service.impl;

import cn.ikangjia.fun.mysql.entity.UserDO;
import cn.ikangjia.fun.mysql.mapper.UserMapper;
import cn.ikangjia.fun.mysql.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
        log.info(userDO.toString());
        return userDO.getName();
    }
}
