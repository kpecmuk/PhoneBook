package ru.kpecmuk.phone_book;

import java.util.Map;

/**
 * @author kpecmuk
 * @since 15.02.2017
 */
interface I_Contact {

    String getName();

    int getId();

    void setId(int id);

    Map<Integer, PhoneNumber> getPhoneNumbers();
}