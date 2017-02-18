package ru.kpecmuk.phone_book;

import ru.kpecmuk.phone_book.tools.Validator;

/**
 * ИСПОЛНЯЮЩИЙ ИНТЕРФЕЙС телефонной книги
 *
 * @author kpecmuk
 * @since 14.02.17
 */
public interface I_PhoneBook {
    void viewContacts(I_PhoneBook phoneBook, Validator validator);

    void addContact(I_PhoneBook phoneBook, Validator validator);

    void deleteContact(I_PhoneBook phoneBook, Validator validator);

    void addPhone(String phoneNumber, Validator validator);

    void deletePhone(String phoneNumber, Validator validator);
}
