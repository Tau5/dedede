package dedede.view;

import dedede.domain.User;

public class ReturnBookView implements View {
    private User user;
    public ReturnBookView(User user) {
        this.user = user;
    }

    @Override
    public void run(Model model, ViewManager viewManager) {
        var books = model.books;

        //books.findAllList().
    }
}
