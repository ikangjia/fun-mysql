package cn.ikangjia.fun.mysql.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * SQL 执行器
 *
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/10/9 15:06
 */
@Slf4j
@Component
public class ExecuteHandler {
    private final JdbcThreadLocal jdbcThreadLocal;

    public ExecuteHandler(JdbcThreadLocal jdbcThreadLocal) {
        this.jdbcThreadLocal = jdbcThreadLocal;
    }

    public void execute(String sql){
        try (Statement statement = this.getStatement()){
            statement.execute(sql);
        } catch (SQLException e) {
            throw new DMSException(e.getMessage(), e);
        }
    }

    private Statement getStatement() {
        Connection context = jdbcThreadLocal.getContext();
        try {
            return context.createStatement();
        } catch (SQLException e) {
            log.error("获取 Statement 失败{}", e.getMessage());
            throw new DMSException(e.getMessage(), e);
        }
    }

    private Statement getPrepareStatement(String sqlTemplate, String... params) {
        Connection context = jdbcThreadLocal.getContext();
        try {
            PreparedStatement statement = context.prepareStatement(sqlTemplate);
            if (params == null || params.length == 0) {
                return statement;
            }
            for (int i = 0, j = params.length; i < j; i++) {
                statement.setObject(i+1, params[i]);
            }
            return statement;
        } catch (SQLException e) {
            log.error("获取 PrepareStatement 失败{}", e.getMessage());
            throw new DMSException(e.getMessage(), e);
        }
    }

}
