import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class mainStage extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Image Editor");

        Group root = new Group();
        Scene mainScene = new Scene(root, 1152, 648);
        final Menu menuFile = new Menu("File");
        final Menu menuOptions = new Menu("Options");
        final Menu menuHelp = new Menu("Help");
        MenuBar menuBar = new MenuBar();
        menuBar.setMinWidth(mainScene.getWidth());
        menuBar.getMenus().addAll(menuFile, menuOptions , menuHelp);

        root.getChildren().add(menuBar);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}
