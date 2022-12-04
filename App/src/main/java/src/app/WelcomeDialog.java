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

public class WelcomeDialog extends Application implements EventHandler<ActionEvent> {
    private GridPane grid;
    private Text formTitle, notification;
    private Label whoAreYouLabel, toLoginLabel, toRegisterLabel;

    private Button loginButton, registrationButton;
    private Scene scene;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Welcome Dialog");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        formTitle = new Text("Welcome");

        formTitle.setId("formatTitle");
        grid.add(formTitle, 0, 0, 2, 1);

        whoAreYouLabel = new Label("Do you have account?");
        grid.add(whoAreYouLabel, 0, 1);

        whoAreYouLabel = new Label("if you want to log: ");
        grid.add(whoAreYouLabel, 0, 2);

        whoAreYouLabel = new Label("if you want to make an account: ");
        grid.add(whoAreYouLabel, 1, 2);

        loginButton = new Button("Sign In");
        loginButton.setOnAction(this);

        grid.add(loginButton, 0, 3);
        grid.setHalignment(loginButton, HPos.LEFT);

        registrationButton = new Button("Register");
        registrationButton.setOnAction(this);

        grid.add(registrationButton, 1, 3);
        grid.setHalignment(registrationButton, HPos.RIGHT);

        notification = new Text();
        notification.setId("notification");
        grid.add(notification, 1, 6);

        scene = new Scene(grid, 600, 675);
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
        if (event.getSource() == loginButton) {
            notification.setText("Sign in button pressed");
            Stage stage = new Stage();
            LoginDialog loginDialog = new LoginDialog();
            loginDialog.start(stage);
        }
        else if (event.getSource() == registrationButton) {
            notification.setText("Registration button pressed");
            Stage stage = new Stage();
            RegistrationDialog registrationDialog = new RegistrationDialog();
            registrationDialog.start(stage);
        }
    }
}
