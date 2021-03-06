package ru.kpecmuk.phone_book.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author kpecmuk
 * @since 15.02.2017
 */
public class Validator implements Closeable {
    private final Logger log = LoggerFactory.getLogger(Validator.class.getSimpleName());
    private final IO io;

    public Validator(IO io) {
        this.io = io;
    }

    public void showText(String text) {
        this.io.print(text);
    }

    public int getInt(String message) {
        boolean invalid;
        do {
            try {
                showText(message);
                return Integer.valueOf(this.io.read());
            } catch (Exception e) {
                invalid = true;
                this.io.read();
            }
        } while (invalid);
        throw new UnsupportedOperationException();
    }

    public String getString(String message) {
        showText(message);
        return this.io.read();
    }

    @Override
    public void close() throws IOException {
    }
}
