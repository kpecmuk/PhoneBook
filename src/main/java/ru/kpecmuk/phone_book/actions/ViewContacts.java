package ru.kpecmuk.phone_book.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpecmuk.phone_book.I_PhoneBook;
import ru.kpecmuk.phone_book.tools.Validator;

/**
 * @author kpecmuk
 * @since 18.02.2017
 */
public class ViewContacts implements Action {
    private static final int VIEW_CONTACTS_KEY = 1;
    private final String actionIntro = " - View contacts\n";
    private final Logger logger = LoggerFactory.getLogger(ViewContacts.class.getSimpleName());

    @Override
    public void execute(I_PhoneBook phoneBook, Validator validator) {
        logger.info("Running action " + actionIntro);
        phoneBook.viewContacts(validator);
    }

    @Override
    public String info() {
        return (this.key() + actionIntro);
    }

    @Override
    public int key() {
        return VIEW_CONTACTS_KEY;
    }
}
