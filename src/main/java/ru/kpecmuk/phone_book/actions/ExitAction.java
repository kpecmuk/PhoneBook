package ru.kpecmuk.phone_book.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpecmuk.phone_book.I_PhoneBook;
import ru.kpecmuk.phone_book.tools.Validator;

/**
 * @author kpecmuk
 * @since 18.02.2017
 */
public class ExitAction implements Action {
    private final Logger logger = LoggerFactory.getLogger(ExitAction.class.getSimpleName());

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
