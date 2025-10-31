package dedede.view.bibliotecario;

import dedede.view.*;

public class DeleteLibroView implements View {
    @Override
    public void run(Model model, ViewManager viewManager) {
        model.books.findAll().forEach(book -> {
            System.out.println(book);
        });

        int id = MenuHelper.getNumber("ID a eliminar");

        var maybeBook = model.books.findByIdOptional((long) id);
        maybeBook.ifPresentOrElse(
            book -> {
                model.books.deleteById(book.getID());
            },
            () -> {
                System.out.println("Error: No existe un libro con ese ID");
            }
        );

        viewManager.switchView(new ViewBibliotecario());
    }
}
