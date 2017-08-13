import javafx.application.Application;
import javafx.stage.Stage;
import store.MainMenu;

public class Main extends Application{
    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        MainMenu mainMenu = new MainMenu(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
