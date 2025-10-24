package dedede.view;

abstract class View {
    Model model;
    ViewManager viewManager;

    abstract void run();
    public View(Model model, ViewManager viewManager) {
        this.model = model;
        this.viewManager = viewManager;
    }
}
