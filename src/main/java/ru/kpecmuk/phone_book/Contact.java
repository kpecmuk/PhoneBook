package ru.kpecmuk.phone_book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ОПИСАНИЕ КОНТАКТА, имя, список номеров
 * phoneNumberMap - карта телефонных номеров (id, I_PhoneNumber)
 *
 * @author kpecmuk
 * @since 15.02.17
 */
public class Contact implements I_Contact {
    private final Logger logger = LoggerFactory.getLogger(Contact.class.getSimpleName());
    private final String name;
    private final Map<Integer, I_PhoneNumber> phoneNumberMap = new LinkedHashMap<>();
    private int id;

    Contact(String name) {
        this.name = name;
    }

    @Override
    public String getContactName() {
        logger.info(" returning " + this.name);
        return this.name;
    }

    @Override
    public int getContactID() {
        logger.info(" returning " + this.id);
        return this.id;
    }

    @Override
    public void setContactID(int id) {
        logger.info(" setting " + id);
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(this.name);
        if (phoneNumberMap.isEmpty()) {
            result.append(" --> Phone numbers not found\n");
        } else {
            result.append(" --> ");
            for (I_PhoneNumber phone : this.phoneNumberMap.values()) {
                result.append(phone.getPhoneNumber()).append("   ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    @Override
    public Map<Integer, I_PhoneNumber> getPhoneNumberMap() {
        return this.phoneNumberMap;
    }

    @Override
    public I_PhoneNumber getPhoneIDbyNumber(String phoneNumber) {
        for (I_PhoneNumber phone : this.phoneNumberMap.values()) {
            if (phoneNumber.equals(phone.getPhoneNumber())) {
                return this.phoneNumberMap.get(phone.getID());
            }
        }
        throw new UnsupportedOperationException();
    }
}
