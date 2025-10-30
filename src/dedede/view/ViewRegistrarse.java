package dedede.view;

import dedede.domain.User;

public class ViewRegistrarse extends View {
    public ViewRegistrarse(Model model, ViewManager viewManager) {
        super(model, viewManager);
    }

    @Override
    void run() {
        MenuHelper.sc.reset();
        System.out.print("nombre: ");
        MenuHelper.sc.nextLine();
        String nombre = MenuHelper.sc.nextLine();
        System.out.print("apellidos: ");
        String apellidos = MenuHelper.sc.nextLine();

        User user = new User(
            nombre, apellidos
        );

        user = this.model.users.save(user);

        System.out.println(user.getID());

        viewManager.switchView(
            new HomeUsuario(model, viewManager, user)
        );
    }
}
