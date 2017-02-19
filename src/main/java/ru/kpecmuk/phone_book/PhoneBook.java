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
    private Map<Integer, I_Contact> contacts = new LinkedHashMap<>();

    @Override
    public void viewContacts(Validator validator) {
        for (I_Contact contact : contacts.values()) {
            validator.showText(contact.getName() + "\n");
        }
    }

    @Override
    public void addContact(Contact contact) {
        contact.setId(contactIds.incrementAndGet());
        this.contacts.put(contact.getId(), contact);
    }

    @Override
    public void deleteContact(String contactName, Validator validator) {

        for (I_Contact contact : contacts.values()) {
            if (contact.getName().equals(contactName)) {
                this.contacts.remove(contact.getId());
                break;
            }
        }
        this.viewContacts(validator);
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