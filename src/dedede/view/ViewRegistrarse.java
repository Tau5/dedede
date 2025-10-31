package dedede.view;

import dedede.domain.User;

public class ViewRegistrarse implements View {
    @Override
    public void run(Model model, ViewManager viewManager) {
        MenuHelper.sc.reset();
        System.out.print("nombre: ");
        MenuHelper.sc.nextLine();
        String nombre = MenuHelper.sc.nextLine();
        System.out.print("apellidos: ");
        String apellidos = MenuHelper.sc.nextLine();

        User user = new User(
            nombre, apellidos
        );

        user = model.users.save(user);

        System.out.println(user.getID());

        viewManager.switchView(
            new UserHomeView(user)
        );
    }
}
