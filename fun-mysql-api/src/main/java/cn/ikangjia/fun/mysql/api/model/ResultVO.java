package cn.ikangjia.fun.mysql.api.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/10/5 22:51
 */
@Getter
@Setter
public class ResultVO<T> {
    private Integer code;
    private T t;
    private String msg;

    public ResultVO(Integer code, T t, String msg) {
        this.code = code;
        this.t = t;
        this.msg = msg;
    }

    public static <T> ResultVO<T> success(T t) {
        return new ResultVO<>(0, t, null);
    }

    public static <T> ResultVO<T> error(String msg) {
        return new ResultVO<>(1, null, msg);
    }

}
