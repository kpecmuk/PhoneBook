package ru.kpecmuk.phone_book.actions;

import ru.kpecmuk.phone_book.I_PhoneBook;
import ru.kpecmuk.phone_book.tools.Validator;

/**
 * @author kpecmuk
 * @since 14.02.17
 */
public class AddContactAction implements Action {

    @Override
    public void execute(I_PhoneBook phoneBook, Validator validator) {
        phoneBook.addContact(phoneBook, validator);
    }

    public String info() {
        return (this.key() + " - Add new contact\n");
    }

    public int key() {
        return 2;
    }
}