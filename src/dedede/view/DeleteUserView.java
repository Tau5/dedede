package dedede.view;

import dedede.domain.User;
import dedede.view.usuario.UserHomeView;

public class DeleteUserView implements View{

    private User user;

    public DeleteUserView(User user) {
        this.user = user;
    }
    @Override
    public void run(Model model, ViewManager viewManager) {
        var users = model.users;

        users.findAllList().forEach(System.out::println);
        var id = MenuHelper.getNumber("Ingrese el id del usuario que quiera eliminar:");
        users.findAllList().forEach(user1 -> {
            if (user.getID() == id){
                model.users.deleteById(user1.getID());
                System.out.println("Usuario eliminado correctamente");
            }
        });
        viewManager.switchView(new UserHomeView(user));
    }

}
