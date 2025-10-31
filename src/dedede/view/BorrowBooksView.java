package dedede.view;

import dedede.domain.User;

public class BorrowBooksView implements View{
    private User user;
    public BorrowBooksView(User user) {
        this.user = user;
    }

    @Override
    public void run(Model model, ViewManager viewManager) {
        var books = model.books;
        books.findAllList().forEach((book) -> {
            if (!book.isBorrowed()) {
                System.out.println("[" + book.getID() + "] " + book.getTitle() + " (" + book.getAuthor() + ")");
            }
        });

        var id = MenuHelper.getNumber("Ingrese el id del libro que quiere prestar");

        books.findAllList().forEach((book) -> {
            if (book.getID() == id) {
                if (!book.isBorrowed()) {
                    user.borrowBook(book);
                    model.books.save(book);
                    System.out.println("Libro prestado.");
                } else {
                    System.out.println("No se puede prestar el libro, ya esta prestado");
                }
            }
        });

        viewManager.switchView(new HomeUsuario(user));
    }
}
