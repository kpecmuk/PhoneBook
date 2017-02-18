package ru.kpecmuk.phone_book.actions;

import ru.kpecmuk.phone_book.I_PhoneBook;

/**
 * @author kpecmuk
 * @since 14.02.17
 */
public class AddContactAction implements Action {

    @Override
    public void execute(I_PhoneBook phoneBook) {
        System.out.println("add contact");
    }

    public String info() {
        return (this.key() + " - Add new contact\n");
    }

    public int key() {
        return 1;
    }
}