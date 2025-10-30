package dedede.view;

import dedede.domain.User;

public class BorrowBooksView extends View{

    private User user;

    public BorrowBooksView(Model model, ViewManager viewManager, User user) {
        super(model, viewManager);
        this.user = user;
    }

    @Override
    void run() {
        var books = model.books;
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

        viewManager.switchView(new HomeUsuario(model, viewManager, user));
    }
}
