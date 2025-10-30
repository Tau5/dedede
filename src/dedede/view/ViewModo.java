package dedede.view;

public class ViewModo implements View {
    @Override
    public void run(Model model, ViewManager viewManager) {
        MenuHelper menu = new MenuHelper();

        menu.registerOption(1, "Usuario", () -> new ViewUsuario());
        menu.registerOption(2, "Bibliotecario", () -> new ViewBibliotecario());

        View nextView = menu.chooseAndExecute("opcion: ");

        viewManager.switchView(nextView);
    }
}
