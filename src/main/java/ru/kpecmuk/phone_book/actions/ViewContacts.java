package ru.kpecmuk.phone_book.actions;

import ru.kpecmuk.phone_book.I_PhoneBook;
import ru.kpecmuk.phone_book.tools.Validator;

/**
 * @author kpecmuk
 * @since 18.02.2017
 */
public class ViewContacts implements Action {
    @Override
    public void execute(I_PhoneBook phoneBook, Validator validator) {
        phoneBook.viewContacts(phoneBook, validator);
    }

    @Override
    public String info() {
        return (this.key() + " - View all phonebook\n");
    }

    @Override
    public int key() {
        return 1;
    }
}
