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
    public static final int EXIT_KEY = 6;
    private final String actionIntro = " - Exit program\n";
    private final Logger log = LoggerFactory.getLogger(ExitAction.class.getSimpleName());

    @Override
    public void execute(I_PhoneBook phoneBook, Validator validator) {
        log.info("Running action " + actionIntro);
    }

    @Override
    public String info() {
        return (this.key() + actionIntro);
    }

    @Override
    public int key() {
        return EXIT_KEY;
    }
}
