package src.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * Class Main
 *
 * @author ewa.miazga
 */

public class Main extends Application {

    /**
     * primary Stage
     */
    Stage primaryStage;
    /**
     * The func that generates first window.
     *
     * @param primaryStage
     */
    public void start(Stage primaryStage) {
        primaryStage = new Stage();
        primaryStage.setTitle("SeaSupPort");

        StackPane layout = new StackPane();
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