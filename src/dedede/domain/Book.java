package dedede.domain;

import java.time.Instant;

public class Book {
    private Long ID;
    private String title;
    private String author;
    private Boolean borrowed;
    private Long userID;
    private Instant borrowStart;
    private Instant borrowEnd;


    public Book(Long ID, String title, String author, boolean borrowed, long userID, Instant borrowStart, Instant borrowEnd) {
        this.title = title;
        this.ID = ID;
        this.author = author;
        this.borrowed = borrowed;
        this.borrowStart = borrowStart;
        this.borrowEnd = borrowEnd;
        this.userID = userID;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Boolean borrowed) {
        this.borrowed = borrowed;
    }

    public Instant getBorrowEnd() {
        return borrowEnd;
    }

    public void setBorrowEnd(Instant borrowEnd) {
        this.borrowEnd = borrowEnd;
    }

    public Instant getBorrowStart() {
        return borrowStart;
    }

    public void setBorrowStart(Instant borrowStart) {
        this.borrowStart = borrowStart;
    }
}
