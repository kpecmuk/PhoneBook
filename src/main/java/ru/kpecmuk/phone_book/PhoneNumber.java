package ru.kpecmuk.phone_book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Объект - телефонный номер
 *
 * @author kpecmuk
 * @since 15.02.2017
 */
class PhoneNumber implements I_PhoneNumber {
    private final Logger log = LoggerFactory.getLogger(PhoneBook.class.getSimpleName());
    private final String phoneNumber;
    private final int id;

    PhoneNumber(int id, String phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    public int getID() {
        log.info("returning phone ID - " + this.id);
        return this.id;
    }

    public String getPhoneNumber() {
        log.info("returning phone number - " + this.phoneNumber);
        return this.phoneNumber;
    }
}
