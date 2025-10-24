package dedede.view;

public class ViewUsuario extends View {
    public ViewUsuario(Model model, ViewManager viewManager) {
        super(model, viewManager);
    }

    @Override
    void run() {
        System.out.println("Modo usuario");
        viewManager.switchView(
                new ViewModo(this.model, this.viewManager)
        );
    }
}
