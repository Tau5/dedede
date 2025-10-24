package dedede.view;

public class ViewModo extends View {
    public ViewModo(Model model, ViewManager viewManager) {
        super(model, viewManager);
    }

    @Override
    void run() {
        MenuHelper menu = new MenuHelper();

        menu.registerOption(1, "Usuario", () -> new ViewUsuario(this.model, this.viewManager));
        menu.registerOption(2, "Bibliotecario", () -> new ViewBibliotecario(this.model, this.viewManager));

        View nextView = menu.chooseAndExecute("opcion: ");

        viewManager.switchView(nextView);
    }
}
