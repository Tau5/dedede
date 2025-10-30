package dedede.view;

import dedede.domain.User;

public class ViewIniciarSesion implements View {
    @Override
    public void run(Model model, ViewManager viewManager) {
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

        viewManager.switchView(
            new HomeUsuario(usuario)
        );
    }
}
