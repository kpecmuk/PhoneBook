package ru.kpecmuk.phone_book.actions;

/**
 * @author kpecmuk
 * @since  14.02.17
 */
public class DeleteContactAction implements Action {
    public void execute() {

    }

    public String info() {
        return this.key() + " - Delete contact";
    }

    public int key() {
        return 2;
    }
}
