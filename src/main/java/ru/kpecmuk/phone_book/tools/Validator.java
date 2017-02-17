package ru.kpecmuk.phone_book.tools;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author kpecmuk
 * @since 15.02.2017
 */
public class Validator implements Closeable {
    private IO io;

    public Validator(IO io) {
        this.io = io;
    }

    public int getInt(String message) {
        boolean invalid;
        do {
            try {
                io.println(message);
                return Integer.valueOf(this.io.read());
            } catch (Exception e) {
                invalid = true;
                this.io.read();
            }
        } while (invalid);
        throw new UnsupportedOperationException();
    }

    public String getString(String message) {
        io.println(message);
        return this.io.read();
    }

    @Override
    public void close() throws IOException {
    }
}