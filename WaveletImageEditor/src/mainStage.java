import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;

public class mainStage extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainStage) {

        // Create MenuBar
        MenuBar menuBar = new MenuBar();


        // Create menus
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Options");
        Menu helpMenu = new Menu("Help");

        // Create MenuItems
        MenuItem openImage = new MenuItem("Open Image");
        MenuItem saveImage = new MenuItem("Save Image");
        MenuItem exitItem = new MenuItem("Exit");

        // Set Accelerator for Exit MenuItem.
        exitItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        // Set Accelerator for Save Image MenuItem.
        saveImage.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
        // Set Accelerator for Open Image MenuItem.
        openImage.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));

        // When user click on the Exit item.
        exitItem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        // When user click on the Save Image.
        saveImage.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        // When user click on the Open Image.
        openImage.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                configuringFileChooser(fileChooser);
                fileChooser.showOpenDialog(mainStage);
            }
        });

        // Add menuItems to the Menus
        fileMenu.getItems().addAll(openImage, saveImage, exitItem);

        // Add Menus to the MenuBar
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);

        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        Scene mainScene = new Scene(root, 1152, 648);

        mainStage.setTitle("Image Editor");
        mainStage.setScene(mainScene);
        mainStage.show();
    }

    private void configuringFileChooser(FileChooser fileChooser) {
        // Set title for FileChooser
        fileChooser.setTitle("Select Pictures");

        // Set Initial Directory
        fileChooser.setInitialDirectory(new File("C:/Users/tran/Pictures"));

        // Add Extension Filters
        fileChooser.getExtensionFilters().addAll(//
                new FileChooser.ExtensionFilter("All Files", "*.*"), //
                new FileChooser.ExtensionFilter("JPG", "*.jpg"), //
                new FileChooser.ExtensionFilter("PNG", "*.png"));
    }

}
