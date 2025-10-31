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
        System.out.println("Lista de libros que no estan prestados");
        books.findAllList().forEach(book -> {
            if (!book.isBorrowed()) {
                System.out.println(book);
            }
        });
        var id = MenuHelper.getNumber("Ingrese el id del libro que quiere prestar");
        books.findAllList().forEach((book) -> {
            if (book.getID() == id) {
                if (!book.isBorrowed()) {
                    user.borrowBook(book);
                    model.books.save(book);
                    System.out.println("Libro prestado.");
                }
            }
        });

        viewManager.switchView(new UserHomeView(user));
    }
}
