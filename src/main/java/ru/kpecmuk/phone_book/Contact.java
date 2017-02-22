package ru.kpecmuk.phone_book;

import com.sun.org.apache.xpath.internal.operations.Neg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.invoke.empty.Empty;

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
    private final Map<Integer, I_PhoneNumber> phoneNumberMap = new LinkedHashMap<>();
    private int id;

    public Contact(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        logger.info("inside contact toString()");
        String result = this.name;
        if (phoneNumberMap.isEmpty()) {
            result += " --> Phone numbers not found\n";
        } else {
            result += " --> ";
            for (I_PhoneNumber phone : this.phoneNumberMap.values()) {
                result += phone.getPhoneNumber() + "   ";
            }
            result += "\n";
        }
        return result;
    }

    @Override
    public Map<Integer, I_PhoneNumber> getPhoneNumberMap() {
        return this.phoneNumberMap;
    }

    @Override
    public I_PhoneNumber findPhoneNumber(String phoneNumber) {
        for (I_PhoneNumber phone : this.phoneNumberMap.values()) {
            if (phoneNumber.equals(phone.getPhoneNumber())) {
                return this.phoneNumberMap.get(phone.getID());
            }
        }
        throw new UnsupportedOperationException();
    }
}
