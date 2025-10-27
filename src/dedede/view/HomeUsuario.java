package dedede.view;

import dedede.domain.User;
import dedede.repository.UserRepository;

public class HomeUsuario extends View {

    public HomeUsuario(Model model, ViewManager viewManager, User user) {
        super(model, viewManager);
    }

    @Override
    void run() {

        MenuHelper menu = new MenuHelper();

        menu.registerOption(1, "Ver libros prestados", () -> null );
        menu.registerOption(2, "Pedir libro prestado", () -> null);
        menu.registerOption(3, "Devolver libro", () -> null);
        menu.registerOption(4, "Eliminar cuenta", () -> null);
        menu.registerOption(5, "Salir", () -> new ViewModo(this.model, this.viewManager));

        View nextView = menu.chooseAndExecute("opcion: ");
        viewManager.switchView(nextView);
    }

}
