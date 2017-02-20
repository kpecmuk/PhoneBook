package ru.kpecmuk.phone_book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ОПИСАНИЕ КОНТАКТА, имя, список номеров
 * возможно добавятся ещё свойства
 *
 * @author kpecmuk
 * @since 15.02.17
 */
public class Contact implements I_Contact {
    private final Logger logger = LoggerFactory.getLogger(Contact.class.getSimpleName());
    private int id;
    private final String name;
    private final Map<Integer, PhoneNumber> phoneNumbers = new LinkedHashMap<>();

    public Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, PhoneNumber> getPhoneNumbers() {
        return this.phoneNumbers;
    }
}