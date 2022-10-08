package cn.ikangjia.fun.mysql.infra;

import cn.ikangjia.fun.mysql.api.model.ResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/10/8 20:29
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResultVO<Object> handlerException(Exception e) {
        return Optional.of(e.getMessage())
                .map(ResultVO::error)
                .orElse(ResultVO.error("服务器内部错误"));
    }
}
