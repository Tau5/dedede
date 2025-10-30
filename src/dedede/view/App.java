package dedede.view;

import dedede.repository.BookRepository;

import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        Model model;
        try {
            model = new Model(new File("books.csv"), new File("users.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ViewManager viewManager = new ViewManager(model);
        viewManager.switchView(new ViewModo());
    }
}
