package ru.kpecmuk.phone_book.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpecmuk.phone_book.I_PhoneBook;
import ru.kpecmuk.phone_book.tools.Validator;

/**
 * @author kpecmuk
 * @since 14.02.17
 */
public class DeleteContactAction implements Action {
    private final Logger logger = LoggerFactory.getLogger(DeleteContactAction.class.getSimpleName());

    @Override
    public void execute(I_PhoneBook phoneBook, Validator validator) {
        phoneBook.deleteContact(phoneBook, validator);
    }

    public String info() {
        return (this.key() + " - Delete contact\n");
    }

    public int key() {
        return 3;
    }
}
