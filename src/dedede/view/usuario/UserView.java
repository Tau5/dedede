package dedede.view.usuario;

import dedede.view.*;

public class UserView implements View {
    @Override
    public void run(Model model, ViewManager viewManager) {
        MenuHelper menu = new MenuHelper();

        menu.registerOption(1, "Iniciar sesión", ViewIniciarSesion::new);
        menu.registerOption(2, "Registrarse", ViewRegistrarse::new);
        menu.registerOption(3, "Volver", ViewModo::new);

        View view = menu.chooseAndExecute("opción:");

        viewManager.switchView(view);
    }
}
