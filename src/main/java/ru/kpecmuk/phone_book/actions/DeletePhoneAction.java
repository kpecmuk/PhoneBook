package ru.kpecmuk.phone_book.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpecmuk.phone_book.I_PhoneBook;
import ru.kpecmuk.phone_book.tools.Validator;

/**
 * @author kpecmuk
 * @since 21.02.2017
 */
public class DeletePhoneAction implements Action {
    private static final int DELETE_PHONE_NUMBER = 5;
    private final String actionIntro = " - Delete phone number\n";
    private final Logger log = LoggerFactory.getLogger(DeletePhoneAction.class.getSimpleName());

    @Override
    public void execute(I_PhoneBook phoneBook, Validator validator) {
        log.info("Running action " + actionIntro);
        phoneBook.deletePhoneNumber(validator.getString("Enter phone number: "));
    }

    @Override
    public String info() {
        return (this.key() + actionIntro);
    }

    @Override
    public int key() {
        return DELETE_PHONE_NUMBER;
    }
}
