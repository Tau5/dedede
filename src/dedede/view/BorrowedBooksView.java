package dedede.view;

import dedede.domain.User;

public class BorrowedBooksView extends View {
    
    private User user;

    public BorrowedBooksView(Model model, ViewManager viewManager, User user) {
        super(model, viewManager);
        this.user = user;
    }

    @Override
    void run() {
        var books = model.books;
        books.findAllList().forEach((book) -> {
            if (book.getUserID() == user.getID()) {
                System.out.println();
            }
        });

        viewManager.switchView(new HomeUsuario(model, viewManager, user));
    }
}
