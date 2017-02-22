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
                logger.info("Contact " + contact + " already exist");
                return;
            }
        }
        contact.setId(contactIds.incrementAndGet());
        this.contacts.put(contact.getId(), contact);
        logger.info("Contact " + contact.getName() + " added");
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
                logger.info("Contact " + contactName + " deleted");
                break;
            }
        }
    }

    /**
     * Сразу создали объект телефонного номера с ID и номером
     * Далее ищем тот контакт куда добавляем номер.
     *
     * @param name   CONTACT NAME
     * @param number PHONE NUMBER
     */
    @Override
    public void addPhoneNumber(String name, String number) {
        PhoneNumber phoneNumber = new PhoneNumber(phoneIds.incrementAndGet(), number);
        for (I_Contact contact : contacts.values()) {
            if (name.equals(contact.getName())) {
                try {
                    contact.getPhoneNumberID(number);
                    logger.info("Phone number already exist");
                } catch (UnsupportedOperationException e) { // мы тут, значит такого номера нет
                    contact.getPhoneNumberMap().put(phoneNumber.getID(), phoneNumber);
                    logger.info("Phone " + number + " added to " + contact.getName());
                }
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
        for (I_Contact contact : contacts.values()) {
            try {
                contact.getPhoneNumberMap().values().remove(contact.getPhoneNumberID(phoneNumber));
                logger.info("Phone " + phoneNumber + " deleted");
            } catch (UnsupportedOperationException e) {
                logger.info("Nothing found");
            }
        }
    }
}
