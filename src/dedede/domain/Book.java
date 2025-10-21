package dedede.domain;

import java.time.Instant;

public class Book {
    private Long ID;
    private String titel;
    private String author;
    private boolean borrowed;
    private long userID;
    private Instant borrowStart;
    private Instant borrowEnd;


    public Book(String titel, Long ID, String author, boolean borrowed, Instant borrowStart, Instant borrowEnd, long userID) {
        this.titel = titel;
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

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
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

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
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
