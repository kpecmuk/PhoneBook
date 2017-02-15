package ru.kpecmuk.phone_book.tools;

import java.util.Scanner;

/**
 * @author kpecmuk
 * @since 15.02.2017
 */
public class Validator {
    private final Scanner scanner;

    public Validator() {
        this.scanner = new Scanner(System.in);
    }

    public int getInt(String message){
        boolean invalid;
        do {
            try {
                System.out.print(message);
                return Integer.valueOf(this.scanner.nextInt());
            } catch (Exception e) {
                invalid = true;
                scanner.next();
            }
        } while (invalid);
        throw new UnsupportedOperationException();
    }

    public String getString(String message) {
        System.out.print(message);
        return this.scanner.next();
    }
}