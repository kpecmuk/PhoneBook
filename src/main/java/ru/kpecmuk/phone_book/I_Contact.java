package ru.kpecmuk.phone_book;

import java.util.Map;

/**
 * @author kpecmuk
 * @since 15.02.2017
 */
interface I_Contact {

    String getContactName();

    int getContactID();

    void setContactID(int id);

    Map<Integer, I_PhoneNumber> getPhoneNumberMap();

    I_PhoneNumber getPhoneNumberID(String phoneNumber);
}
