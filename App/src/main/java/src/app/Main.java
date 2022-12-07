package src.app;

import javafx.application.Application;
import javafx.stage.Stage;
import src.logic.CaptainsEntity;


/**
 * Class Main
 *
 * @author ewa.miazga
 */
public class Main extends Application {

    /**
     * primary Stage
     */
    private Stage primaryStage;
    /**
     * The func that run application
     *
     * @param primaryStage
     */
    public void start(Stage primaryStage) {
        primaryStage = new Stage();
        primaryStage.setTitle("SeaSupPort");


        WelcomeDialog welcomeDialog = new WelcomeDialog();
        welcomeDialog.start(primaryStage);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        DataBase.getInstance(); // connecting with database
        launch(args);
        DataBase.disableConnection(); // disconnecting with database
    }
}