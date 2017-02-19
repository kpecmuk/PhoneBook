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
    private final Logger logger = LoggerFactory.getLogger(AddContactAction.class.getSimpleName());

    @Override
    public void execute(I_PhoneBook phoneBook, Validator validator) {
        Contact contact = new Contact(validator.getString("Enter contact name: "));
        phoneBook.addContact(contact);
    }

    public String info() {
        return (this.key() + " - Add new contact\n");
    }

    public int key() {
        return 2;
    }
}