package ru.kpecmuk.phone_book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpecmuk.phone_book.tools.Validator;

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
    private final Logger logger = LoggerFactory.getLogger(PhoneBook.class.getSimpleName());
    private final AtomicInteger contactIds = new AtomicInteger();
    private final AtomicInteger phoneIds = new AtomicInteger();
    private final Map<Integer, I_Contact> contacts = new LinkedHashMap<>();

    @Override
    public void viewContacts(I_PhoneBook phoneBook, Validator validator) {
        for (I_Contact contact : contacts.values()) {
            validator.showText(contact.getName() + "\n");
        }
    }

    @Override
    public void addContact(I_PhoneBook phoneBook, Validator validator) {
        this.contacts.put
                (contactIds.incrementAndGet(),
                        new Contact(validator.getString("Enter contact name: ")));
        this.viewContacts(phoneBook, validator);
    }

    @Override
    public void deleteContact(I_PhoneBook phoneBook, Validator validator) {
        try {
            this.contacts.remove(validator.getString("Enter contact name: "));
        } catch (Exception e) {
            validator.showText("Nothing to remove\n");
        } finally {
            this.viewContacts(phoneBook, validator);
        }
    }

    @Override
    public void addPhone(String phoneNumber, Validator validator) {
        System.out.println("Inside addPhone");
        PhoneNumber number = new PhoneNumber(phoneIds.incrementAndGet(), phoneNumber);
    }

    @Override
    public void deletePhone(String phoneNumber, Validator validator) {
        System.out.println("Inside deletePhone");
    }
}