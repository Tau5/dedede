package dedede.view;

public class ViewModo implements View {
    @Override
    public void run(Model model, ViewManager viewManager) {
        MenuHelper menu = new MenuHelper();

        menu.registerOption(1, "Usuario", UserView::new);
        menu.registerOption(2, "Bibliotecario", ViewBibliotecario::new);

        View nextView = menu.chooseAndExecute("opcion: ");

        viewManager.switchView(nextView);
    }
}
