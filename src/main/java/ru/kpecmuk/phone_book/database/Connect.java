package ru.kpecmuk.phone_book.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author kpecmuk
 * @since 23.02.2017
 */
public class Connect {
    private final Logger logger = LoggerFactory.getLogger(Connect.class.getSimpleName());
    private final String url;
    private final Properties connectionProps;

    public Connect(String login, String password) {
        this.url = "jdbc:postgresql://localhost:5432/phone";
        this.connectionProps = new Properties();
        connectionProps.put("user", login);
        connectionProps.put("password", password);
    }

    public boolean checkConnection() {
        Connection connection = null;
        boolean result = true;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(this.url, this.connectionProps);
        } catch (Exception e) {
            result = false;
            logger.error(e.getMessage());
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
        return result;
    }
}
