package dedede.view.usuario;

import dedede.domain.User;
import dedede.view.*;

public class ViewIniciarSesion implements View {
    @Override
    public void run(Model model, ViewManager viewManager) {
        if (model.users.count() < 1) {
            System.out.println("No hay usuarios, regístrate y vuelve a intentarlo");
            viewManager.switchView(
                new UserView()
            );
            return;
        }

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
            new UserHomeView(usuario)
        );
    }
}
