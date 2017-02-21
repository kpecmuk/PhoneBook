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
    private final String name;
    private final Map<Integer, PhoneNumber> phoneNumbers = new LinkedHashMap<>();
    private int id;

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

    @Override
    public String toString() {
        logger.info("inside contact toString()");
        String result = this.name;
        if (phoneNumbers.isEmpty()) {
            result += " --> Phone numbers not found\n";
        } else {
            result += " --> ";
            for (PhoneNumber phone : this.phoneNumbers.values()) {
                result += phone.getPhoneNumber() + "   ";
            }
            result += "\n";
        }
        return result;
    }

    @Override
    public Map<Integer, PhoneNumber> getPhoneNumbers() {
        return this.phoneNumbers;
    }
}