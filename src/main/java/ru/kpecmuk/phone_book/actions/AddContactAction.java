package ru.kpecmuk.phone_book.actions;

import ru.kpecmuk.phone_book.I_PhoneBook;

/**
 * @author kpecmuk
 * @since  14.02.17
 */
public class AddContactAction implements Action {

    public void execute(I_PhoneBook phoneBook) {

    }


    public String info() {
        return this.key() + " - Add new contact";
    }

    public int key() {
        return 1;
    }
}