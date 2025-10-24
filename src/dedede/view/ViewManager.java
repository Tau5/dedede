package dedede.view;

public class ViewManager {
    View currentView;
    Model model;

    public void switchView(View view) {
        currentView = view;
        view.run();
    }
}
