package cn.ikangjia.fun.mysql.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/10/8 9:03
 */
@Data
@TableName("t_user")
public class UserDO {
    private Long id;
    private String name;
    private String account;
    private String password;
    private String avatar;
    private String phone;
    private String email;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    @TableField("is_deleted")
    private boolean deleted;
}
