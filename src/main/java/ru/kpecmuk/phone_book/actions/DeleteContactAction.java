package ru.kpecmuk.phone_book.actions;

import ru.kpecmuk.phone_book.I_PhoneBook;

/**
 * @author kpecmuk
 * @since 14.02.17
 */
public class DeleteContactAction implements Action {

    @Override
    public void execute(I_PhoneBook phoneBook) {
        System.out.println("delete contact");
    }

    public String info() {
        return this.key() + " - Delete contact\n";
    }

    public int key() {
        return 2;
    }
}
