package dedede.view;

import dedede.domain.User;

public class BorrowedBooksView implements View {
    private User user;
    public BorrowedBooksView(User user) {
        this.user = user;
    }

    @Override
    public void run(Model model, ViewManager viewManager) {
        var books = model.books;
        books.findAllList().forEach((book) -> {
            if (book.getUserID() == user.getID() && book.isBorrowed()) {
                System.out.println(book);
            }
        });

        viewManager.switchView(new UserHomeView(user));
    }
}
