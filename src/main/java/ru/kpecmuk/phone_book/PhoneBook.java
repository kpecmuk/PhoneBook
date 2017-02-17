package ru.kpecmuk.phone_book;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Релизация I_PhoneBook
 * Добавление контакта
 * Удаление контакта
 * Добавление номера
 * Удаление номера
 *
 * @author kpecmuk
 * @since 14.02.17
 */
public class PhoneBook implements I_PhoneBook {
    private final AtomicInteger contactIds = new AtomicInteger();
    private final AtomicInteger phoneIds = new AtomicInteger();
    private final Map<Integer, I_Contact> contacts = new LinkedHashMap<>();

    @Override
    public void addContact(String name) {
        this.contacts.put(contactIds.incrementAndGet(), new Contact(name));
    }

    @Override
    public int deleteContact(String name) {
        return 0;
    }

    @Override
    public void addPhone(String phoneNumber) {
        PhoneNumber number = new PhoneNumber(phoneIds.incrementAndGet(), phoneNumber);
    }

    @Override
    public int deletePhone(String phoneNumber) {
        return 0;
    }
}