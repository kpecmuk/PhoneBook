package ru.kpecmuk.phone_book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

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

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}