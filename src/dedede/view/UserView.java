package dedede.view;

public class UserView implements View {
    @Override
    public void run(Model model, ViewManager viewManager) {
        MenuHelper menu = new MenuHelper();

        menu.registerOption(1, "Iniciar sesión", () -> new ViewIniciarSesion());
        menu.registerOption(2, "Registrarse", () -> new ViewRegistrarse());

        View view = menu.chooseAndExecute("opción: ");

        viewManager.switchView(view);
    }
}
