package ru.kpecmuk.phone_book;

import ru.kpecmuk.phone_book.actions.Action;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kpecmuk
 * @since 14.02.17
 */
public class PhoneBookUI {
    private final I_PhoneBook phoneBook = new PhoneBook();
    private final Map<Integer, Action> actionMap = new ConcurrentHashMap<>();

    public PhoneBookUI() {
    }

    public void loadAction(Action action) {
        this.actionMap.put(action.key(), action);
    }

    public void show() {
        this.info(this.actionMap);
    }

    private void info(Map<Integer, Action> actionMap) {
        System.out.println(">>> Welcome screen <<<");
        for (final Action action : this.actionMap.values()) {
            System.out.println(action.info());
        }
    }
}