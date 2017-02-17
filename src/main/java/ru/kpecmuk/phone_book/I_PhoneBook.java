package ru.kpecmuk.phone_book;

/**
 * ИСПОЛНЯЮЩИЙ ИНТЕРФЕЙС телефонной книги
 *
 * @author kpecmuk
 * @since 14.02.17
 */
public interface I_PhoneBook {
    void addContact(String contactName);

    int deleteContact(String name);

    void addPhone(String phoneNumber);

    int deletePhone(String phoneNumber);
}
