package ru.kpecmuk.phone_book.tools;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author kpecmuk
 * @since 16.02.2017
 */
public class ConsoleIO implements IO {
    private final Scanner scanner;
    private final PrintStream out;

    public ConsoleIO() {
        this.scanner = new Scanner(System.in);
        this.out = System.out;
    }

    @Override
    public void print(Object value) {
        this.out.print(value);
    }

    @Override
    public String read() {
        return this.scanner.next();
    }
}
