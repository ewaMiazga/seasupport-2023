package src.app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Class LoginDialog
 *
 * @author ewa.miazga
 */
public class LoginDialog extends Application implements EventHandler<ActionEvent> {
    private GridPane grid;
    private Text formTitle, notification;
    private Label userLoginLabel, userPassLabel;
    private TextField userLoginField;
    private PasswordField userPassField;
    private Button signInButton;
    private Scene scene;
    private String cssPath;
    @Override
    public void start(Stage stage) {
        //TODO
    }

    /**
     * The entry point of class LoginDialog
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        //TODO
    }
}
