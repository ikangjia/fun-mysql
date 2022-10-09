package cn.ikangjia.fun.mysql.core;

import cn.ikangjia.fun.mysql.entity.DataSourceDO;
import org.springframework.util.StringUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2022/10/9 8:52
 */
public class DataSourceUtil {
    private static final String URL_TEMPLATE = "jdbc:mysql://%s:%s";

    public static Boolean testConnection(DataSourceDO dataSourceDO) {
        return testConnection(dataSourceDO.getHost(), dataSourceDO.getPort(), dataSourceDO.getUsername(), dataSourceDO.getPassword(), dataSourceDO.getDefaultDb());
    }

    private static Boolean testConnection(String host, String port, String username, String password, String defaultDb) {
        String url = String.format(URL_TEMPLATE, host, port);
        if (StringUtils.hasText(defaultDb)) {
            url += "/" + defaultDb;
        }
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return statement.execute("select 1");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
