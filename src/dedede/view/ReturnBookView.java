package dedede.view;

import dedede.domain.User;

public class ReturnBookView extends View {

    private User user;
    public ReturnBookView(Model model, ViewManager viewManager, User user) {
        super(model, viewManager);
        this.user = user;
    }

    @Override
    void run() {
        var books = model.books;

        //books.findAllList().
    }
}
