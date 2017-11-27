package ru.kpecmuk.phone_book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpecmuk.phone_book.actions.*;

import java.io.IOException;
import java.sql.SQLException;

/**
 * ФАЙЛ ЗАПУСКА
 * Создание объекта, добавление действий, запуск
 * По завершению освобождение ресурсов
 *
 * @author kpecmuk
 * @since 14.02.17
 */
class PhoneBookRunner {
    private static final Logger log = LoggerFactory.getLogger(PhoneBookRunner.class.getSimpleName());

    public static void main(String[] args) throws IOException, SQLException {

        PhoneBookUI ui = new PhoneBookUI();
        log.info(ui + " created!");

        ui.loadAction(new ViewContacts());
        ui.loadAction(new AddContactAction());
        ui.loadAction(new DeleteContactAction());
        ui.loadAction(new AddPhoneNumber());
        ui.loadAction(new DeletePhoneAction());
        ui.loadAction(new ExitAction());
        ui.show();
        ui.close();
    }
}
