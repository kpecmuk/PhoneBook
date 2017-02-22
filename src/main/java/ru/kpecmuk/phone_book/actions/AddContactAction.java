package ru.kpecmuk.phone_book.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpecmuk.phone_book.Contact;
import ru.kpecmuk.phone_book.I_PhoneBook;
import ru.kpecmuk.phone_book.tools.Validator;

/**
 * @author kpecmuk
 * @since 14.02.17
 */
public class AddContactAction implements Action {
    private static final int ADD_CONTACT_KEY = 2;
    private final String actionIntro = " - New contact\n";
    private final Logger logger = LoggerFactory.getLogger(AddContactAction.class.getSimpleName());

    @Override
    public void execute(I_PhoneBook phoneBook, Validator validator) {
        logger.info("Running action " + actionIntro);
        phoneBook.addContact(new Contact(validator.getString("Enter contact name: ")));
    }

    public String info() {
        return (this.key() + actionIntro);
    }

    public int key() {
        return ADD_CONTACT_KEY;
    }
}
