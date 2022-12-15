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
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import org.hibernate.annotations.Check;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * The type Registration dialog.
 */
public class RegistrationDialog extends Application implements EventHandler<ActionEvent> {

    private GridPane grid;

    private Text formTitle, notification;

    private Label userLoginLabel, userPassLabel, userPassConfLabel, userTypeLabel, forenameLabel, surnameLabel, numberLabel, peselLabel, birthdayLabel;

    private TextField userLoginField, userTypeField, forenameField, surnameField, numberField, peselField;
    private TextField userPassVisibleField, userPassVisibleConfField;

    private DatePicker birthdayPicker;
    private final String pattern = "dd/MM/yy";
    private PasswordField userPassField, userPassConfField;

    private CheckBox showPass, showPassConf;
    private Button registerButton;

    private Scene scene;

    private Stage registrationStage;

    private String cssPath;
    @Override
    public void start(Stage stage) {
        registrationStage = stage;
        stage.setTitle("Registration Dialog");
        stage.getIcons().add(
                new Image(
                        WelcomeDialog.class.getResourceAsStream("Logo.png")));

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


        formTitle = new Text("Registration Form");
        formTitle.setId("formatTitle");
        grid.add(formTitle, 0, 0, 2, 1);

        userLoginLabel = new Label("Login: ");
        grid.add(userLoginLabel, 0, 1);

        userLoginField = new TextField();
        grid.add(userLoginField, 1, 1);

        showPass = new CheckBox("Show password");
        grid.add(showPass, 1, 3);

        userPassLabel = new Label("Password: ");
        grid.add(userPassLabel, 0, 2);

        userPassVisibleField = new TextField();
        userPassVisibleField.setManaged(false);
        userPassVisibleField.setVisible(false);

        userPassField = new PasswordField();
        showPassword(userPassField, userPassVisibleField, showPass);

        grid.add(userPassField, 1, 2);
        grid.add(userPassVisibleField, 1,2);

        showPassConf = new CheckBox("Show confirmation password");
        grid.add(showPassConf, 1, 5);

        userPassConfLabel = new Label("Confirm password: ");
        grid.add(userPassConfLabel, 0, 4);

        userPassVisibleConfField = new TextField();
        userPassVisibleConfField.setManaged(false);
        userPassVisibleConfField.setVisible(false);

        userPassConfField = new PasswordField();
        showPassword(userPassConfField, userPassVisibleConfField, showPassConf);

        grid.add(userPassConfField, 1, 4);
        grid.add(userPassVisibleConfField, 1,4);

        userTypeLabel = new Label("Type of user: ");
        grid.add(userTypeLabel, 0, 6);

        userTypeField = new TextField();
        grid.add(userTypeField, 1, 6);

        forenameLabel = new Label("Forename: ");
        grid.add(forenameLabel, 0, 7);

        forenameField = new TextField();
        grid.add(forenameField, 1, 7);

        surnameLabel = new Label("Surname: ");
        grid.add(surnameLabel, 0, 8);

        surnameField = new TextField();
        grid.add(surnameField, 1, 8
        );

        numberLabel = new Label("Phone Number: ");
        grid.add(numberLabel, 0, 9);

        numberField = new TextField();
        grid.add(numberField, 1, 9);

        birthdayLabel = new Label("Date of Birth: ");
        grid.add(birthdayLabel, 0, 10);

        Locale.setDefault(Locale.ENGLISH);
        birthdayPicker = new DatePicker();
        birthdayPicker.setConverter(createStringConverter());
        birthdayPicker.setPromptText(pattern.toLowerCase());

        grid.add(birthdayPicker, 1, 10);

        peselLabel = new Label("Pesel: ");
        grid.add(peselLabel, 0, 11);

        peselField = new TextField();
        grid.add(peselField, 1, 11);


        registerButton = new Button("Register");
        registerButton.setOnAction(this);

        grid.add(registerButton, 1, 13);
        grid.setHalignment(registerButton, HPos.RIGHT);

        notification = new Text();
        notification.setId("notification");
        grid.add(notification, 1, 12);

        scene = new Scene(grid, 600, 575);
        cssPath = this.getClass().getResource("LoginDialog.css").toExternalForm();
        scene.getStylesheets().add(cssPath);
        stage.setScene(scene);
        stage.show();
        userLoginField.requestFocus();
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
            String userLogin = userLoginField.getText();
            String userPass = userPassField.getText();
            String userPassConf = userPassConfField.getText();
            if (!userPass.equals(userPassConf)) {
                notification.setText("Passwords are different!");
                return;
            }
            String userType = userTypeField.getText();
            String userForename = forenameField.getText();
            String userSurname = surnameField.getText();
            String userNumber = numberField.getText();
            String userPesel = peselField.getText();
            String userBirthday = birthdayPicker.toString();
            LoginDialog loginDialog = new LoginDialog();
            if (userLogin.equals("") || userPass.equals("") || userPassConf.equals("") || userType.equals("") ||
                    userForename.equals("") || userSurname.equals("") || userNumber.equals("") || userPesel.equals("") ||
                    userBirthday.equals("")) {
                notification.setText("Required fields are empty!");
                return;
            }
            loginDialog.start(registrationStage);
        }
    }

    public void showPassword(PasswordField field, TextField text, CheckBox box) {
            text.managedProperty().bind(box.selectedProperty());
            text.visibleProperty().bind(box.selectedProperty());

            field.managedProperty().bind(box.selectedProperty().not());
            field.visibleProperty().bind(box.selectedProperty().not());

            text.textProperty().bindBidirectional(field.textProperty());
        }

    public StringConverter createStringConverter() {
        StringConverter converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter =
                    DateTimeFormatter.ofPattern(pattern);
            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };

        return converter;
        }
    }
