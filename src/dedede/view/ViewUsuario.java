package dedede.view;

public class ViewUsuario extends View {
    public ViewUsuario(Model model, ViewManager viewManager) {
        super(model, viewManager);
    }

    @Override
    void run() {
        MenuHelper menu = new MenuHelper();

        menu.registerOption(1, "Iniciar sesión", () -> new ViewIniciarSesion(model, viewManager));
        menu.registerOption(2, "Registrarse", () -> new ViewRegistrarse(model, viewManager));

        View view = menu.chooseAndExecute("opción: ");

        viewManager.switchView(view);
    }
}
