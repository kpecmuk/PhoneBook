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
    public void addContact(I_Contact contact) {
        for (I_Contact contactExist : contacts.values()) {
            if (contactExist.getContactName().equals(contact.getContactName())) {
                logger.info("Contact " + contact + " already exist");
                return;
            }
        }
        contact.setContactID(contactIds.incrementAndGet());
        this.contacts.put(contact.getContactID(), contact);
        logger.info("Contact " + contact.getContactName() + " added");
    }

    /**
     * Удаление контанта из списка MAP <> contacts
     *
     * @param contactName имя контакта, по которому ведется поиск и удаление
     */
    @Override
    public void deleteContact(String contactName) {
        for (I_Contact contact : contacts.values()) {
            if (contact.getContactName().equals(contactName)) {
                this.contacts.remove(contact.getContactID());
                logger.info("Contact " + contactName + " deleted");
                break;
            }
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
    public void addPhoneNumber(String contactName, String contactNumber) {
        boolean newContact = true;
        for (I_Contact contact : contacts.values()) {
            if (contactName.equals(contact.getContactName())) {
                newContact = false;                 // имя контакта найдено
                try {
                    contact.getPhoneNumberID(contactNumber);
                    logger.info("Phone number already exist");
                } catch (UnsupportedOperationException e) { // мы тут, значит такого номера нет
                    PhoneNumber phoneNumber = new PhoneNumber(phoneIds.incrementAndGet(), contactNumber);
                    contact.getPhoneNumberMap().put(phoneNumber.getID(), phoneNumber);
                    logger.info("Phone " + contactNumber + " added to " + contact.getContactName());
                }
            }
        }
        if (newContact) {
            logger.info("No contact found. Creating new contact and phone number");
            addNewContactAndPhone(contactName, contactNumber);
        }
    }

    /**
     * Если мы сюда попали, значит мы пытались добавить номер в несуществующий контакт
     * Сразу создаём 2 объекта - имя контакта и телефон
     */
    private void addNewContactAndPhone(String contactName, String contactNumber) {
        addContact(new Contact(contactName));
        addPhoneNumber(contactName, contactNumber);
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
