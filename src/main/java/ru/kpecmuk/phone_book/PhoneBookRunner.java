package ru.kpecmuk.phone_book;

import ru.kpecmuk.phone_book.actions.AddContactAction;
import ru.kpecmuk.phone_book.actions.DeleteContactAction;

/**
 * @author kpecmuk
 * @since 14.02.17
 */
public class PhoneBookRunner {

    public static void main(String[] args) {

        PhoneBookUI ui = new PhoneBookUI();

        ui.loadAction(new AddContactAction());
        ui.loadAction(new DeleteContactAction());
        ui.show();

    }
}
