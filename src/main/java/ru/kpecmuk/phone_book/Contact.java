package ru.kpecmuk.phone_book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * ОПИСАНИЕ КОНТАКТА, имя, список номеров
 * возможно добавятся ещё свойства
 *
 * @author kpecmuk
 * @since 15.02.17
 */
public class Contact implements I_Contact {
    private final Logger logger = LoggerFactory.getLogger(Contact.class.getSimpleName());
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