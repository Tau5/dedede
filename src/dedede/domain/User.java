package dedede.domain;

import java.time.Instant;

public class User {

    private Long ID;
    private String name;
    private String surname;

    public User(Long ID, String name, String surname) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
    }

    public User(String name, String surname) {
        this.ID = null;
        this.name = name;
        this.surname = surname;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void borrowBook(Book book) {
        book.setBorrowed(true);
        book.setUserID(this.ID);
        book.setBorrowStart(Instant.now());
        book.setBorrowEnd(Instant.now());
    }

    public void returnBook(Book book) {
        book.setBorrowed(false);
    }
}
