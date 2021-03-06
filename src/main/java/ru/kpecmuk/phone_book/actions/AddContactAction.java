package ru.kpecmuk.phone_book.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpecmuk.phone_book.I_PhoneBook;
import ru.kpecmuk.phone_book.tools.Validator;

/**
 * @author kpecmuk
 * @since 14.02.17
 */
public class AddContactAction implements Action {
    private static final int ADD_CONTACT_KEY = 2;
    private final String actionIntro = " - Add new contact\n";
    private final Logger log = LoggerFactory.getLogger(AddContactAction.class.getSimpleName());

    @Override
    public void execute(I_PhoneBook phoneBook, Validator validator) {
        log.info("Running action " + actionIntro);
        phoneBook.addContact(validator.getString("Enter contact name: "));
    }

    public String info() {
        return (this.key() + actionIntro);
    }

    public int key() {
        return ADD_CONTACT_KEY;
    }
}
