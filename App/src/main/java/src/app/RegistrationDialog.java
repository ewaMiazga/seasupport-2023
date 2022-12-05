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

public class RegistrationDialog extends Application implements EventHandler<ActionEvent> {

    private GridPane grid;

    private Text formTitle;

    private Label userLoginLabel, userPassLabel, userPassConfLabel, userTypeLabel, forenameLabel, surnameLabel, numberLabel, peselLabel, birthdayLabel;

    private TextField userLoginField, userTypeField, forenameField, surnameField, numberField, peselField, birthdayField;

    private PasswordField userPassField, userPassConfField;

    private Button registerButton;

    private Scene scene;

    private Stage registrationStage;

    private String cssPath;
    @Override
    public void start(Stage stage) {
        registrationStage = stage;
        stage.setTitle("Registration Dialog");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        formTitle = new Text("Welcome");
        formTitle.setId("formatTitle");
        grid.add(formTitle, 0, 0, 2, 1);

        userLoginLabel = new Label("Login: ");
        grid.add(userLoginLabel, 0, 1);

        userLoginField = new TextField();
        grid.add(userLoginField, 1, 1);

        userPassLabel = new Label("Password: ");
        grid.add(userPassLabel, 0, 2);

        userPassField = new PasswordField();
        grid.add(userPassField, 1, 2);

        userPassConfLabel = new Label("Confirm password: ");
        grid.add(userPassConfLabel, 0, 3);

        userPassConfField = new PasswordField();
        grid.add(userPassConfField, 1, 3);

        userTypeLabel = new Label("Type of user: ");
        grid.add(userTypeLabel, 0, 4);

        userTypeField = new TextField();
        grid.add(userTypeField, 1, 4);

        forenameLabel = new Label("Forename: ");
        grid.add(forenameLabel, 0, 5);

        forenameField = new TextField();
        grid.add(forenameField, 1, 5);

        surnameLabel = new Label("Surname: ");
        grid.add(surnameLabel, 0, 6);

        surnameField = new TextField();
        grid.add(surnameField, 1, 6);

        numberLabel = new Label("Phone Number: ");
        grid.add(numberLabel, 0, 7);

        numberField = new TextField();
        grid.add(numberField, 1, 7);

        birthdayLabel = new Label("Date of Birth: ");
        grid.add(birthdayLabel, 0, 8);

        birthdayField = new TextField();
        grid.add(birthdayField, 1, 8);

        peselLabel = new Label("Pesel: ");
        grid.add(peselLabel, 0, 9);

        peselField = new TextField();
        grid.add(peselField, 1, 9);


        registerButton = new Button("Register");
        registerButton.setOnAction(this);

        grid.add(registerButton, 1, 11);
        grid.setHalignment(registerButton, HPos.RIGHT);

        scene = new Scene(grid, 600, 575);
        cssPath = this.getClass().getResource("loginDialog.css").toExternalForm();
        scene.getStylesheets().add(cssPath);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The entry point of class RegistrationDialog
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == registerButton) {
            registerButton.setText("Register button pressed");
            LoginDialog loginDialog = new LoginDialog();
            loginDialog.start(registrationStage);
        }
    }


    }
