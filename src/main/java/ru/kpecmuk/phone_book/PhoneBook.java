package ru.kpecmuk.phone_book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpecmuk.phone_book.tools.Validator;

import java.util.ArrayList;
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

    /**
     * Просмотр списка контактов, пока без номеров
     */
    @Override
    public void viewContacts(Validator validator) {
        for (I_Contact contact : contacts.values()) {
            validator.showText(contact.toString());
        }
    }

    /**
     * Добавление контакта в MAP <> contacts
     *
     * @param contact контакт уже с именем, далее здесь ему присваивается ID
     *                и затем всё это кладем в MAP <> contacts
     *                ID - необходимый параметр для дальнейшей работы с MAP
     */
    @Override
    public void addContact(Contact contact) {
        for (I_Contact contactExist : contacts.values()) {
            if (contactExist.getName().equals(contact.getName())) {
                return;
            }
        }
        contact.setId(contactIds.incrementAndGet());
        this.contacts.put(contact.getId(), contact);
    }

    /**
     * Удаление контанта из списка MAP <> contacts
     *
     * @param contactName имя контакта, по которому ведется поиск и удаление
     */
    @Override
    public void deleteContact(String contactName) {
        for (I_Contact contact : contacts.values()) {
            if (contact.getName().equals(contactName)) {
                this.contacts.remove(contact.getId());
                break;
            }
        }
    }

    /**
     * Сразу создали объект телефонного номера с ID и номером
     * Далее ищем тот контакт куда добавляем номер.
     * TODO добавить проверку дублирования номеров
     *
     * @param name   CONTACT NAME
     * @param number PHONE NUMBER
     */
    @Override
    public void addPhoneNumber(String name, String number) {
        PhoneNumber phoneNumber = new PhoneNumber(phoneIds.incrementAndGet(), number);
        for (I_Contact contact : contacts.values()) {
            if (name.equals(contact.getName())) {
                contact.getPhoneNumberMap().put(phoneNumber.getID(), phoneNumber);
            }
        }
    }

    /**
     * Удаление телефонного номера.
     * Номер ищем по всем контактам и удаляем
     *
     * @param phoneNumber номер телефона, который будет удалён
     */
    @Override
    public void deletePhoneNumber(String phoneNumber) {
        for (I_Contact contact : this.contacts.values()) {
            for (I_PhoneNumber phone : contact.getPhoneNumberMap().values()) {
                if (phoneNumber.equals(phone.getPhoneNumber())) {
                    contact.getPhoneNumberMap().remove(phone.getID());
                    break;
                }
            }
        }
    }
}
