package ru.kpecmuk.phone_book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpecmuk.phone_book.actions.Action;
import ru.kpecmuk.phone_book.database.Database;
import ru.kpecmuk.phone_book.tools.ConsoleIO;
import ru.kpecmuk.phone_book.tools.Validator;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static ru.kpecmuk.phone_book.actions.ExitAction.EXIT_KEY;

/**
 * Меню интерфейса
 *
 * @author kpecmuk
 * @since 14.02.17
 */
class PhoneBookUI {
    private final Logger logger = LoggerFactory.getLogger(PhoneBookUI.class.getSimpleName());
    private final PhoneBook phoneBook = new PhoneBook();
    private final Map<Integer, Action> actionMenu = new ConcurrentHashMap<>();
    private final Validator validator = new Validator(new ConsoleIO());
    private final Database database = new Database();

    PhoneBookUI() throws SQLException {
        logger.info("Created : " + this.getClass().getSimpleName());
    }

    void loadAction(Action action) {
        logger.info(" UI <-- " + action.getClass().getSimpleName());
        this.actionMenu.put(action.key(), action);
    }

    void show() throws IOException {
        validator.showText(this.database.checkConnection() ? "SQL Connected\n" : "SQL Error\n");
        do {
            this.info(this.actionMenu);
            int userAction = validator.getInt("> Your action: ");
            doAction(userAction);
            if (userAction == EXIT_KEY) {
                this.close();
                break;
            }
        }
        while (true);
    }

    /**
     * Выполнить действие
     */
    private void doAction(int userAction) {
        for (final Action action : actionMenu.values()) {
            if (userAction == action.key()) {
                action.execute(this.phoneBook, this.validator);     // запуск действия
                return;
            }
        }
    }

    private void info(Map<Integer, Action> actionMap) {
        validator.showText(">>> PHONE BOOK OPTIONS <<<\n");
        for (final Action action : actionMap.values()) {
            validator.showText(action.info());
        }
    }

    /**
     * Закрываем ресурсы
     *
     * @throws IOException some text
     */
    void close() throws IOException {
        this.validator.close();
        this.actionMenu.clear();
    }
}
