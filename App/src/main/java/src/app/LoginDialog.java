package src.app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
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
    private TextField userLoginField, userPassVisibleField;
    private PasswordField userPassField;
    private CheckBox showPass;
    private Button signInButton;
    private Scene scene;
    private Stage loginStage;
    private String cssPath;
    @Override
    public void start(Stage stage) {
        loginStage = stage;
        stage.setTitle("Login Dialog");
        stage.getIcons().add(
                new Image(
                        WelcomeDialog.class.getResourceAsStream("Logo.png")));

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        userLoginLabel = new Label("Login: ");
        grid.add(userLoginLabel, 0, 1);

        userLoginField = new TextField();
        grid.add(userLoginField, 1, 1);

        userPassLabel = new Label("Password: ");
        grid.add(userPassLabel, 0, 2);

        userPassVisibleField = new TextField();
        userPassVisibleField.setManaged(false);
        userPassVisibleField.setVisible(false);
        userPassField = new PasswordField();

        grid.add(userPassField, 1, 2);
        grid.add(userPassVisibleField, 1, 2);

        showPass = new CheckBox("Show password");
        showPass.setAlignment(Pos.CENTER_RIGHT);
        grid.add(showPass, 1, 3);

        userPassVisibleField.managedProperty().bind(showPass.selectedProperty());
        userPassVisibleField.visibleProperty().bind(showPass.selectedProperty());

        userPassField.managedProperty().bind(showPass.selectedProperty().not());
        userPassField.visibleProperty().bind(showPass.selectedProperty().not());

        userPassVisibleField.textProperty().bindBidirectional(userPassField.textProperty());

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
        loginStage.setScene(scene);
        loginStage.centerOnScreen();
        loginStage.show();
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
        //database @bartek
        if (event.getSource() == signInButton) {
            String userLogin = userLoginField.getText();
            String userPass = userPassField.getText();
            //@bartek TODO:
            PortsDialog portsDialog = new PortsDialog();
            portsDialog.start(loginStage);
        }
    }
}
