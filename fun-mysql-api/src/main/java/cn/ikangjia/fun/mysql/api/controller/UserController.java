package cn.ikangjia.fun.mysql.api.controller;

import cn.ikangjia.fun.mysql.api.model.ResultVO;
import cn.ikangjia.fun.mysql.entity.UserDO;
import cn.ikangjia.fun.mysql.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/10/8 9:23
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResultVO<UserDO> getUser(@PathVariable Long id) {
        return Optional.of(userService.getUser(id))
                .map(ResultVO::success)
                .orElseThrow();
    }

    @PostMapping("/doLogin")
    public ResultVO<String> getUser(@RequestBody UserDO userDO) {
        return Optional.of(userService.doLogin(userDO))
                .map(ResultVO::success)
                .orElseThrow();
    }
}
