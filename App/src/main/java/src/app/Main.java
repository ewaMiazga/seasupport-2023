package src.app;

import javafx.application.Application;
import javafx.application.Platform;
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
    //private Stage primaryStage;
    /**
     * The func that run application
     *
     * @param stage
     */
    public void start(Stage stage) {
        stage = new Stage();
        SplashDialog splashDialog = new SplashDialog();
        try {
            splashDialog.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
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