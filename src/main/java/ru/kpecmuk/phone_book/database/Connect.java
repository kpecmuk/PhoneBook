package ru.kpecmuk.phone_book.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author kpecmuk
 * @since 23.02.2017
 */
public class Connect {
    private final Logger logger = LoggerFactory.getLogger(Connect.class.getSimpleName());
    private final String login;
    private final String password;
    private final String url;

    public Connect(String login, String password) throws SQLException {
        this.url = "jdbc:postgresql://localhost:5432/phone";
        this.login = login;
        this.password = password;
    }

    public boolean checkConnection() {
        Connection connection = null;
        Statement st = null;
        boolean result = true;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(this.url, this.login, this.password);
            st = connection.createStatement();
        } catch (Exception e) {
            result = false;
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                logger.error("Error: " + e.getMessage());
            }
        }
        return result;
    }
}
