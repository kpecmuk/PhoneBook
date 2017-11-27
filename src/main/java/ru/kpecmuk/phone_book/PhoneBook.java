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
     * Просмотр списка контактов с номерами
     */
    @Override
    public void viewContacts(Validator validator) {
        if (contacts.isEmpty()) validator.showText("Empty\n");
        else {
            for (I_Contact contact : contacts.values()) {
                validator.showText(contact.toString());
            }
        }
    }

    /**
     * Проверяем не дублиуем ли имя
     * Если нет, то создаем объект Contact, задаем ему ИМЯ и ID
     * Добавляем контакт в MAP <> contacts
     * ID - необходимый параметр для дальнейшей работы с MAP
     *
     * @param contactName имя контакта
     */
    @Override
    public final void addContact(String contactName) {
        try {
            findContact(contactName);
            logger.info("Contact " + contactName + " already exist");
        } catch (UnsupportedOperationException e) {
            I_Contact contact = new Contact(contactName);
            contact.setContactID(contactIds.incrementAndGet());
            this.contacts.put(contact.getContactID(), contact);
            logger.info("Contact " + contact.getContactName() + " added");
        }
    }

    /**
     * Удаление контанта из списка MAP <> contacts
     *
     * @param contactName имя контакта, по которому ведется поиск и удаление
     */
    @Override
    public final void deleteContact(String contactName) {
        try {
            I_Contact contactIter = findContact(contactName);
            this.contacts.remove(contactIter.getContactID());
            logger.info("Contact " + contactName + " deleted");
        } catch (UnsupportedOperationException e) {
            logger.info("Contact " + contactName + " not found");
        }
    }

    /**
     * Сразу создали объект телефонного номера с ID и номером
     * Далее ищем тот контакт куда добавляем номер.
     *
     * @param contactName   CONTACT NAME
     * @param contactNumber PHONE NUMBER
     */
    @Override
    public final void addPhoneNumber(String contactName, String contactNumber) {
        I_Contact contactIter;
        try {
            contactIter = findContact(contactName);
        } catch (UnsupportedOperationException e) {     // не нашли такое имя, будем создавать новый контакт
            logger.info("Contact name not found");      // с номером телефона
            addNewContactAndPhone(contactName, contactNumber);
            return;
        }
        logger.info("Contact name " + contactIter.getContactName() + " found");
        try {
            contactIter.getPhoneIDbyNumber(contactNumber);
            logger.info("Phone number already exist");
        } catch (UnsupportedOperationException e) {             // мы тут, значит такого номера нет
            PhoneNumber phoneNumber = new PhoneNumber(phoneIds.incrementAndGet(), contactNumber);
            contactIter.getPhoneNumberMap().put(phoneNumber.getID(), phoneNumber);
            logger.info("Phone " + contactNumber + " added to " + contactIter.getContactName());
        }
    }

    /**
     * @return итератор контакта или выкидываем ошибку
     */
    private I_Contact findContact(String contactName) {
        for (I_Contact contact : contacts.values()) {
            if (contactName.equals(contact.getContactName()))
                return contact;
        }
        throw new UnsupportedOperationException();
    }

    /**
     * Если мы сюда попали, значит мы пытались добавить номер в несуществующий контакт
     * Сразу создаём 2 объекта - имя контакта и телефон
     */
    private void addNewContactAndPhone(String contactName, String contactNumber) {
        logger.info("Creating new contact " + contactName + " and phone number " + contactNumber);
        this.addContact(contactName);
        this.addPhoneNumber(contactName, contactNumber);
    }

    /**
     * Удаление телефонного номера.
     * Номер ищем по всем контактам и удаляем
     *
     * @param phoneNumber номер телефона, который будет удалён
     */
    @Override
    public final void deletePhoneNumber(String phoneNumber) {
        for (I_Contact contact : contacts.values()) {
            try {
                contact.getPhoneNumberMap().values().remove(contact.getPhoneIDbyNumber(phoneNumber));
                logger.info("Phone " + phoneNumber + " deleted");
            } catch (UnsupportedOperationException e) {
                logger.info("Nothing found");
            }
        }
    }
}
