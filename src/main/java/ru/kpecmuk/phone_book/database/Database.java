package ru.kpecmuk.phone_book.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author kpecmuk
 * @since 23.02.2017
 */
public class Database {
    private final Logger log = LoggerFactory.getLogger(Database.class.getSimpleName());
    private String host;
    private String login;
    private String password;

    /**
     * Загружаем данные для подключения к БД из файла и сохраняем
     */
    public Database() {

        Properties property = new Properties();
        String propFileName = "database.properties";

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {
            property.load(inputStream);

            this.host = property.getProperty("db.host");
            this.login = property.getProperty("db.login");
            this.password = property.getProperty("db.password");

            inputStream.close();

        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * Проверяем есть ли доступ к БД
     *
     * @return true если да
     */
    public boolean checkConnection() {
        Connection connection = null;
        boolean result = true;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(this.host, this.login, this.password);
        } catch (Exception e) {
            result = false;
            log.error(e.getMessage());
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        }
        return result;
    }
}
