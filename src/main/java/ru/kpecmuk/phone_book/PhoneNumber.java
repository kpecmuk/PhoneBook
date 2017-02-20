package ru.kpecmuk.phone_book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Объект - телефонный номер
 *
 * @author kpecmuk
 * @since 15.02.2017
 */
public class PhoneNumber {
    private final Logger logger = LoggerFactory.getLogger(PhoneBook.class.getSimpleName());
    private String phoneNumber;
    private int id;

    public PhoneNumber(int id, String phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return this.id;
    }
}