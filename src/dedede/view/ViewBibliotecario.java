package dedede.view;

public class ViewBibliotecario implements View {
    @Override
    public void run(Model model, ViewManager viewManager) {
        System.out.println("Modo bibliotecario");
        viewManager.switchView(
                new ViewModo()
        );
    }
}
