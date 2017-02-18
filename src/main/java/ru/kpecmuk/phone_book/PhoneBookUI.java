package ru.kpecmuk.phone_book;

import ru.kpecmuk.phone_book.actions.Action;
import ru.kpecmuk.phone_book.tools.ConsoleIO;
import ru.kpecmuk.phone_book.tools.Validator;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Меню интерфейса
 *
 * @author kpecmuk
 * @since 14.02.17
 */
public class PhoneBookUI {
    private final I_PhoneBook phoneBook = new PhoneBook();
    private final Map<Integer, Action> actionMenu = new ConcurrentHashMap<>();
    private final Validator validator;

    PhoneBookUI() {
        this.validator = new Validator(new ConsoleIO());
    }

    void loadAction(Action action) {
        this.actionMenu.put(action.key(), action);
    }

    void show() throws IOException {
        do {
            this.info(this.actionMenu);
            int action = validator.getInt("> Your action: ");
            if (action == 5) {
                doAction(5);
                this.close();
                break;
            } else
                doAction(action);
        }
        while (true);
    }

    /**
     * Выполнить действие
     */
    public void doAction(int userAction) {
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
    public void close() throws IOException {
        this.validator.close();
        this.actionMenu.clear();
    }
}