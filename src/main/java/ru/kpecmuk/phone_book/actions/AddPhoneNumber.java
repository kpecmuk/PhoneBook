package ru.kpecmuk.phone_book.actions;

import ru.kpecmuk.phone_book.I_PhoneBook;
import ru.kpecmuk.phone_book.tools.Validator;

/**
 * @author kpecmuk
 * @since 20.02.2017
 */
public class AddPhoneNumber implements Action {
    @Override
    public void execute(I_PhoneBook phoneBook, Validator validator) {
        String contactName = validator.getString("Enter contact name: ");
        String phoneNumber = validator.getString("Enter phone number: ");
        phoneBook.addPhoneNumber(contactName, phoneNumber);
    }

    @Override
    public String info() {
        return (this.key() + " - Add phone number\n");
    }

    @Override
    public int key() {
        return 4;
    }
}
