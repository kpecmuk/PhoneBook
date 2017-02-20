package ru.kpecmuk.phone_book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpecmuk.phone_book.actions.*;

import java.io.IOException;

/**
 * ФАЙЛ ЗАПУСКА
 * Создание объекта, добавление действий, запуск
 * По завершению освобождение ресурсов
 *
 * @author kpecmuk
 * @since 14.02.17
 */
public class PhoneBookRunner {
    private final Logger logger = LoggerFactory.getLogger(PhoneBookRunner.class.getSimpleName());

    public static void main(String[] args) throws IOException {

        PhoneBookUI ui = new PhoneBookUI();

        ui.loadAction(new ViewContacts());
        ui.loadAction(new AddContactAction());
        ui.loadAction(new DeleteContactAction());
        ui.loadAction(new AddPhoneNumber());
        ui.loadAction(new ExitAction());
        ui.show();
        ui.close();
    }
}