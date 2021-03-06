package ru.kpecmuk.phone_book.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpecmuk.phone_book.I_PhoneBook;
import ru.kpecmuk.phone_book.tools.Validator;

/**
 * @author kpecmuk
 * @since 20.02.2017
 */
public class AddPhoneNumber implements Action {
    private static final int ADD_PHONE_KEY = 4;
    private final String actionIntro = " - Add phone number\n";
    private final Logger log = LoggerFactory.getLogger(AddPhoneNumber.class.getSimpleName());

    @Override
    public void execute(I_PhoneBook phoneBook, Validator validator) {
        log.info("Running action " + actionIntro);
        String contactName = validator.getString("Enter contact name: ");
        String phoneNumber = validator.getString("Enter phone number: ");
        phoneBook.addPhoneNumber(contactName, phoneNumber);
    }

    @Override
    public String info() {
        return (this.key() + actionIntro);
    }

    @Override
    public int key() {
        return ADD_PHONE_KEY;
    }
}
