package dedede.domain;

import java.time.Instant;

public record User(Long ID, String name, String surname){

    public void borrowBook(Book book) {
        book.setBorrowed(true);
        book.setUserID(this.ID);
        book.setBorrowStart(Instant.now());
    }

    public void returnBook(Book book, Instant endDate) {
        book.setBorrowed(false);
        book.setBorrowEnd(endDate);
    }
}
