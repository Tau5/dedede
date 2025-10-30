The user interface in Dedede is separated into views.

### What is a View

Only a view can be loaded at each time and it should have
any data necessary to render itself, additionally it has the
following attributes:
- `model`
:   Access to the sigleton `Model` which provides access to all
    the data repositories
 
- `viewManager`
:   Access to the sigleton `ViewManager`, this is used to switch to another View,
    as the ViewManager controls which view is shown to the user

Each view must implement a single method: `void run`,
this is executed at the start of the view by the ViewManager

### Creating a View

Let's learn how to define a view. let's imagine we want to build
a view which displays information about a User.

The default View boilerplate is this:

```java
public class ExampleView extends View {
    public ExampleView(Model model, ViewManager viewManager) {
        super(model, viewManager);
    }

    @Override
    void run() {
        System.out.println("Hello world!");
    }
}
```

That's okay, it is important to point out that because the
dedede user interface is terminal based and we don't have a main loop, the program
will exit immediatly if we run this after printing `Hello world!`

#### Accessing the User

This View model follow the OOP conventions of encapsulation,
to have access to a user we specify in the constructor an argument
to provide the User. Another view in the program will provide the user
when constructing the View

```java
public class UserView extends View {
    // We add the user as a property
    User myUser;
    
    // And make it an argument in the constructor
    public UserView(Model model, ViewManager viewManager, User user) {
        super(model, viewManager);
        this.myUser = user;
    }

    @Override
    void run() {
        // We can now access the user
        System.out.println(myUser.getName());
    }
}
```

If this sound confusing let's imagine that what's happening
behind the scenes is this:

```java
void main() {
    User someUser = getUser();
    UserView userView = new UserView(model, viewManager, someUser);
    userView.run();
}
```

## Swithing to a View from another View

Let's imagine that we want to switch to the UserView from another View.
We'll first define this view:

```java
public class FirstView extends View {
    public FirstView(Model model, ViewManager viewManager) {
        super(model, viewManager);
    }

    @Override
    void run() {
        System.out.println("Hello world!");
    }
}
```

To change to the `UserView` we'll have to:

1. Get a `User` using the `UserRepository` in `Model`
2. Initialize the `UserView`
3. Switch to it using the `ViewManager`

```java
@Override
void run() {
    // Get the userRepository from Model
    UserRepository users = this.model.users;
    
    // Get a user from the repository
    User someUser = users.findById(0);
}
```

ViewUser is just a class so we can initialize as any other class:

```java
// in run()
// Initialize the UserView using the user we got
UserView myUserView = new UserView(this.model, this.viewManager, someUser);
```

`ViewManager` provides a method `switchView(View)` to switch to another view:

```java
// in run()
// Switch the view to the one we just initialized
this.viewManager.switchView(myUserView);
```

Adding all together we'd have this:

```java
public class FirstView extends View {
    public FirstView(Model model, ViewManager viewManager) {
        super(model, viewManager);
    }

    @Override
    void run() {
        // Get the userRepository from Model
        UserRepository users = this.model.users;

        // Get a user from the repository
        User someUser = users.findById(0);

        // Initialize the UserView using the user we got
        UserView myUserView = new UserView(this.model, this.viewManager, someUser);

        // Switch the view to the one we just initialized
        this.viewManager.switchView(myUserView);
    }
}
```

### Creating interactive menus easily

**NOTE: Because only one Scanner can be open at a time to access the Scanner you have
to access it trough MenuHelper: `MenuHelper.sc`**

Usually creating a menu is a time consuming task which requires a lot
of looping, switches and input parsing.

Dedede provides the `MenuHelper` class to create menus easily,
it mainly provides a way to generate a menu to switch to other views

In this tutorial we'll make a menu which allows us to switch
to the views we made previously (`ExampleView` and `FirstView`)

We start with the view boilerplate:

```java
public class MenuView extends View {
    public MenuView(Model model, ViewManager viewManager) {
        super(model, viewManager);
    }

    @Override
    void run() {
        
    }
}
```

The usage of `MenuHelper` is simple:

1. Instantiate `MenuHelper`
2. Declare options with `registerOption`
3. Get a `View` from the output of `chooseAndExcute`
4. Switch to it with `ViewManager`

`chooseAndExecute` prompts the user with the list of options, the user chooses an option, and it returns the chosen View

`registerOption` has the following arguments:
- `key`: The number which the user presses to accept the option
- `name`: The name of the option shown to the user
- `func`: A lambda function which instantiates the View

We'll now implement it in our View:

```java
public class MenuView extends View {
    public MenuView(Model model, ViewManager viewManager) {
        super(model, viewManager);
    }

    @Override
    void run() {
        // 1. Instantiate MenuHelper
        MenuHelper myMenuHelper = new MenuHelper();
        
        // 2. Declare options
        myMenuHelper.registerOption(1, "Example view", () -> new ExampleView(model, viewManager));
        myMenuHelper.registerOption(2, "First view", () -> new FirstView(model, viewManager));
        
        // 3. Get the view
        View view = myMenuHelper.chooseAndExecute("choose:");
        
        // 4. Switch to it with viewManager
        viewManager.switchView(view);
    }
}
```

The user will see this:

```
1. Example view
2. First view
choose: 
```
