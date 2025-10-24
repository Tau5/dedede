package dedede.view;

public class ViewBibliotecario extends View {
    public ViewBibliotecario(Model model, ViewManager viewManager) {
        super(model, viewManager);
    }

    @Override
    void run() {
        System.out.println("Modo bibliotecario");
        viewManager.switchView(
                new ViewModo(this.model, this.viewManager)
        );
    }
}
