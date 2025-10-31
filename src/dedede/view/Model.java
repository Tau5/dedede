package dedede.view;

import dedede.repository.BookRepository;
import dedede.repository.UserRepository;

import java.io.File;
import java.io.IOException;

final public class Model {
    public BookRepository books;
    public UserRepository users;

    Model(File booksFile, File usersFile) throws IOException {
        this.books = new BookRepository(booksFile);
        this.users = new UserRepository(usersFile);
    }
}
