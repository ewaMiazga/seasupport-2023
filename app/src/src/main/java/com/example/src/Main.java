package com.example.src;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * Class HelloApplication
 *
 * @author ewa.miazga
 */
public class Main extends Application {

    Button button;

    public void start(Stage primaryStage) {
        primaryStage.setTitle("SeaSupPort");
        button = new Button();
        button.setText("Click me");

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}