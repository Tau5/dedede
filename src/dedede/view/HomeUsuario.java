package dedede.view;

import dedede.domain.User;

public class HomeUsuario extends View {

    private User user;

    public HomeUsuario(Model model, ViewManager viewManager, User user) {
        super(model, viewManager);
        this.user = user;
    }

    @Override
    void run() {

        MenuHelper menu = new MenuHelper();

        menu.registerOption(1, "Ver libros prestados", () -> new BorrowedBooksView(model, viewManager, user));
        menu.registerOption(2, "Pedir libro prestado", () -> new BorrowBooksView(model, viewManager, user));
        menu.registerOption(3, "Devolver libro", () -> null);
        menu.registerOption(4, "Eliminar cuenta", () -> null);
        menu.registerOption(5, "Salir", () -> new ViewModo(this.model, this.viewManager));

        View nextView = menu.chooseAndExecute("opcion: ");
        viewManager.switchView(nextView);
    }
}
