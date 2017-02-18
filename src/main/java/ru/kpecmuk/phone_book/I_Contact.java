package ru.kpecmuk.phone_book;

import java.util.List;

/**
 * @author kpecmuk
 * @since 15.02.2017
 */
public interface I_Contact {

    void addPhoneNumber(String number);

    String getName();

    List<String> getPhones();


}
