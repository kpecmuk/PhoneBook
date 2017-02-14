package ru.kpecmuk.phone_book.actions;

import ru.kpecmuk.phone_book.I_PhoneBook;

/**
 * @// TODO: 14.02.2017 понять
 * Тут мы короче добавляем пункты меню.
 * Это просто пункты, они ничего не делают
 * Запуск действия будет происходить через
 * ссылку, через другой интерфейс.
 * Сам еле понимаю.
 *
 * @author kpecmuk
 * @since 14.02.17
 */
public interface Action {
    void execute(I_PhoneBook phoneBook);

    String info();

    int key();
}