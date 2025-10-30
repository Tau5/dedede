package dedede.view;

import dedede.domain.User;

public class HomeUsuario implements View {
    private User user;
    public HomeUsuario(User user) {
        this.user = user;
    }

    @Override
    public void run(Model model, ViewManager viewManager) {

        MenuHelper menu = new MenuHelper();

        menu.registerOption(1, "Ver libros prestados", () -> new BorrowedBooksView(user));
        menu.registerOption(2, "Pedir libro prestado", () -> new BorrowBooksView(user));
        menu.registerOption(3, "Devolver libro", () -> null);
        menu.registerOption(4, "Eliminar cuenta", () -> null);
        menu.registerOption(5, "Salir", () -> new ViewModo());

        View nextView = menu.chooseAndExecute("opcion: ");
        viewManager.switchView(nextView);
    }
}
