package ru.kpecmuk.phone_book;

import ru.kpecmuk.phone_book.actions.Action;
import ru.kpecmuk.phone_book.tools.Validator;

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
    private final Validator validator = new Validator();

    public PhoneBookUI() {
    }

    public void loadAction(Action action) {
        this.actionMenu.put(action.key(), action);
    }

    public void show() {
        do {
            this.info(this.actionMenu);
            doAction();
        } while (true);
    }

    /**
     * 1 - считать действие
     * 2 - проверить
     * 3 - выполнить
     * 4 - выходим отсюда если выбрано корректное действие
     */
    public void doAction() {
        do {
            for (final Action action : actionMenu.values()) {
                if (validator.getInt("> Your action: ") == action.key()) {
                    action.execute(this.phoneBook);     // запуск действия
                    return;
                }
            }
        } while (true);
    }

    private void info(Map<Integer, Action> actionMap) {
        System.out.println(">>> Welcome screen <<<");
        for (final Action action : this.actionMenu.values()) {
            System.out.println(action.info());
        }
    }
}