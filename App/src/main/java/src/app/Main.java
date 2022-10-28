package src.app;

import javafx.application.Application;
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
    Stage stage;
    /**
     * The func that run application
     *
     * @param primaryStage
     */
    public void start(Stage primaryStage) {
        stage = new Stage();
        stage.setTitle("SeaSupPort");

        LoginDialog loginDialog = new LoginDialog();
        loginDialog.start(stage);
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