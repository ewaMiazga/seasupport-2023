package src.app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
        stage.setTitle("Login Dialog");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        formTitle = new Text("Welcome");
        formTitle.setId("formatTitle");
        grid.add(formTitle, 0, 0, 2, 1);

        userLoginLabel = new Label("User's Login: ");
        grid.add(userLoginLabel, 0, 1);

        userLoginField = new TextField();
        grid.add(userLoginField, 1, 1);

        userPassLabel = new Label("User's Password: ");
        grid.add(userPassLabel, 0, 2);

        userPassField = new PasswordField();
        grid.add(userPassField, 1, 2);

        signInButton = new Button("Sign In");
        signInButton.setOnAction(this);

        grid.add(signInButton, 1, 4);
        grid.setHalignment(signInButton, HPos.RIGHT);

        notification = new Text();
        notification.setId("notification");
        grid.add(notification, 1, 6);

        scene = new Scene(grid, 300, 275);
        cssPath = this.getClass().getResource("LoginDialog.css").toExternalForm();
        scene.getStylesheets().add(cssPath);
        stage.setScene(scene);
        stage.show();
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
        //TODO:
        //Write function, which will check if login and password are equal from those from
        //database @michał
        if (event.getSource() == signInButton) {
            notification.setText("Sign in button pressed");
        }
    }
}
