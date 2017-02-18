package ru.kpecmuk.phone_book.actions;

import ru.kpecmuk.phone_book.I_PhoneBook;
import ru.kpecmuk.phone_book.tools.Validator;

/**
 * @author kpecmuk
 * @since 18.02.2017
 */
public class ExitAction implements Action {
    @Override
    public void execute(I_PhoneBook phoneBook, Validator validator) {
        System.out.println("Save & Exit");
    }

    @Override
    public String info() {
        return (this.key() + " - Exit program\n");
    }

    @Override
    public int key() {
        return 5;
    }
}