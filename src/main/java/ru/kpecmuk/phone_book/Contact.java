package ru.kpecmuk.phone_book;

import java.util.List;

/**
 * @author kpecmuk
 * @since 15.02.17
 */
public class Contact implements I_Contact {
    private String name;
    private List<String> phones;

    public Contact(String name) {
        this.name = name;
    }

    public void addPhoneNumber(String number) {
        phones.add(number);
    }

    public String getName() {
        return name;
    }

    public List<String> getPhones() {
        return phones;
    }
}