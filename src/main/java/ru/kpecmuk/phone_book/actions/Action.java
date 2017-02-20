package ru.kpecmuk.phone_book.actions;

import ru.kpecmuk.phone_book.I_PhoneBook;
import ru.kpecmuk.phone_book.tools.Validator;

/**
 * @author kpecmuk
 *         Тут мы короче добавляем пункты меню.
 *         Это просто пункты, они ничего не делают
 *         Запуск действия будет происходить через
 *         ссылку, через другой интерфейс.
 *         Сам еле понимаю.
 * @since 14.02.17
 */
public interface Action {
    void execute(I_PhoneBook phoneBook, Validator validator);

    String info();

    int key();
}