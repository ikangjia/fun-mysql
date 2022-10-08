package cn.ikangjia.fun.mysql.service;

import cn.ikangjia.fun.mysql.entity.UserDO;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/10/8 9:07
 */
public interface UserService {

    UserDO getUser(Long id);

    String doLogin(UserDO userDO);
}
