package dedede.view;

import dedede.domain.User;

public class ViewIniciarSesion extends View {
    public ViewIniciarSesion(Model model, ViewManager viewManager) {
        super(model, viewManager);
    }

    @Override
    void run() {
        model.users.findAllList().forEach(user -> {
            System.out.println(
                    user.getID() + ": " + user.getName() + " " + user.getSurname()
            );
        });

        int chosen = -1;
        while (!model.users.existsById((long) chosen)) {
            chosen = MenuHelper.getNumber("id:");
        }

        User usuario = model.users.findById((long) chosen);

        System.out.println(usuario.getName());

        this.viewManager.switchView(
            new HomeUsuario(model, viewManager, usuario)
        );
    }
}
