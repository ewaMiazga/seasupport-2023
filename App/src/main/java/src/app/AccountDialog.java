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
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import src.logic.AllUsersEntity;
import src.logic.PortsEntity;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.Locale;

public class AccountDialog extends Application implements EventHandler<ActionEvent> {
    private GridPane grid;
    private Text formTitle, notification;
    private Label userLoginLabel, userPassLabel, userForenameLabel, userSurnameLabel, userPeselLabel, userBirthdayLabel,  userContactNumberLabel, userTypeLabel;
    private Text userLoginText, userPassText, userForenameText, userSurnameText, userPeselText, userBirthdayText, userContactNumberText, userTypeText;
    private Button setUserLoginButton, setUserPassButton, setUserForenameButton, setUserSurnameButton, setUserPeselButton, setUserBirthdayButton, setUserContactNumberButton;
    private Button returnButton;
    private TextField userLoginField, userPassField, userForenameField, userSurnameField, userPeselField, userContactNumberField;

    private DatePicker birthdayPicker;
    private AllUsersEntity selectedUser;

    private final String pattern = "dd/MM/yy";
    private Scene scene;
    private Stage accountStage;
    private String cssPath;
    @Override
    public void start(Stage stage) {

    }
    public void start(Stage stage, PortsEntity port, AllUsersEntity user) {
        accountStage = stage;
        selectedUser = user;
        stage.setTitle("Account Dialog");
        stage.getIcons().add(
                new Image(
                        WelcomeDialog.class.getResourceAsStream("Logo.png")));

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


        formTitle = new Text("Hi " + user.getForename());
        formTitle.setId("formatTitle");
        grid.add(formTitle, 0, 0, 1,1);
        grid.setHalignment(formTitle, HPos.CENTER);

        userLoginLabel = new Label("Login: ");
        grid.add(userLoginLabel, 0, 1);

        userLoginText = new Text(user.getLogin());
        grid.add(userLoginText, 1, 1);

        setUserLoginButton = new Button("Change Login");
        setUserLoginButton.setPrefSize(150, 25);
        setUserLoginButton.setOnAction(this);

        grid.add(setUserLoginButton, 2, 1);
        grid.setHalignment(setUserLoginButton, HPos.CENTER);

        userLoginField = new TextField();
        userLoginField.setManaged(false);
        userLoginField.setVisible(false);

        grid.add(userLoginField, 1 ,1);

        setTextField(setUserLoginButton, userLoginText, userLoginField, "Login");

        userPassLabel = new Label("Password: ");
        grid.add(userPassLabel, 0, 2);

        userPassText = new Text(user.getUserPassword());
        grid.add(userPassText, 1, 2);

        setUserPassButton = new Button("Change Password");
        setUserPassButton.setPrefSize(150, 25);
        grid.add(setUserPassButton, 2, 2);
        grid.setHalignment(setUserPassButton, HPos.CENTER);

        //Change to some dialog to changing passwords
        userPassField = new TextField();
        userPassField.setManaged(false);
        userPassField.setVisible(false);

        grid.add(userPassField, 1 ,2);

        setTextField(setUserPassButton, userPassText, userPassField, "Pass");

        userForenameLabel = new Label("Forename: ");
        grid.add(userForenameLabel, 0, 3);

        userForenameText = new Text(user.getForename());
        grid.add(userForenameText, 1, 3);

        setUserForenameButton = new Button("Change Forename");
        setUserForenameButton.setPrefSize(150, 25);
        grid.add(setUserForenameButton, 2, 3);
        grid.setHalignment(setUserForenameButton, HPos.CENTER);

        userForenameField = new TextField();
        userForenameField.setManaged(false);
        userForenameField.setVisible(false);

        grid.add(userForenameField, 1 ,3);

        setTextField(setUserForenameButton, userForenameText, userForenameField, "Forename");

        userSurnameLabel = new Label("Surname: ");
        grid.add(userSurnameLabel, 0, 4);

        userSurnameText = new Text(user.getSurname());
        grid.add(userSurnameText, 1, 4);

        setUserSurnameButton = new Button("Change Surname");
        setUserSurnameButton.setPrefSize(150, 25);
        grid.add(setUserSurnameButton, 2, 4);
        grid.setHalignment(setUserSurnameButton, HPos.CENTER);

        userSurnameField = new TextField();
        userSurnameField.setManaged(false);
        userSurnameField.setVisible(false);

        grid.add(userSurnameField, 1 ,4);

        setTextField(setUserSurnameButton, userSurnameText, userSurnameField, "Surname");

        userContactNumberLabel = new Label("Contact Number: ");
        grid.add(userContactNumberLabel, 0, 5);

        userContactNumberText = new Text(user.getPhoneNumber());
        grid.add(userContactNumberText, 1, 5);

        setUserContactNumberButton = new Button("Change Contact Number");
        setUserContactNumberButton.setPrefSize(150, 25);
        grid.add(setUserContactNumberButton, 2, 5);
        grid.setHalignment(setUserContactNumberButton, HPos.CENTER);

        userContactNumberField = new TextField();
        userContactNumberField.setManaged(false);
        userContactNumberField.setVisible(false);

        grid.add(userContactNumberField, 1 ,5);

        setTextField(setUserContactNumberButton, userContactNumberText, userContactNumberField, "Contact Number");

        userPeselLabel = new Label("Pesel: ");
        grid.add(userPeselLabel, 0, 6);

        userPeselText = new Text(user.getPesel());
        grid.add(userPeselText, 1, 6);

        setUserPeselButton = new Button("Change Pesel");
        setUserPeselButton.setPrefSize(150, 25);
        grid.add(setUserPeselButton, 2, 6);
        grid.setHalignment(setUserPeselButton, HPos.CENTER);

        userPeselField = new TextField();
        userPeselField.setManaged(false);
        userPeselField.setVisible(false);

        grid.add(userPeselField, 1 ,6);

        setTextField(setUserPeselButton, userPeselText, userPeselField, "Pesel");

        userBirthdayLabel = new Label("Birthday: ");
        grid.add(userBirthdayLabel, 0, 7);

        userBirthdayText = new Text(user.getBirthday().toString());
        grid.add(userBirthdayText, 1, 7);

        setUserBirthdayButton = new Button("Change Birthday");
        setUserBirthdayButton.setPrefSize(150, 25);
        grid.add(setUserBirthdayButton, 2, 7);
        grid.setHalignment(setUserBirthdayButton, HPos.CENTER);

        Locale.setDefault(Locale.ENGLISH);
        birthdayPicker = new DatePicker();
        birthdayPicker.setConverter(createStringConverter());
        birthdayPicker.setPromptText(selectedUser.getBirthday().toString().toLowerCase());

        birthdayPicker.setManaged(false);
        birthdayPicker.setVisible(false);

        setDateField(setUserBirthdayButton, userBirthdayText, birthdayPicker, "Birthday");

        grid.add(birthdayPicker, 1, 7);

        userTypeLabel = new Label("User Type: ");
        grid.add(userTypeLabel, 0, 8);

        userTypeText = new Text(user.getUserType());
        grid.add(userTypeText, 1, 8);

        returnButton = new Button("return");
        returnButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getSource().equals(returnButton)) {
                    PortDialog portDialog = new PortDialog();
                    portDialog.start(stage, port);
                }

            }
        });

        grid.add(returnButton, 2, 9);
        grid.setHalignment(returnButton, HPos.RIGHT);


        notification = new Text();
        notification.setId("notification");
        grid.add(notification, 1, 6);

        scene = new Scene(grid, 600, 575);
        cssPath = this.getClass().getResource("LoginDialog.css").toExternalForm();
        scene.getStylesheets().add(cssPath);
        accountStage.setScene(scene);
        accountStage.centerOnScreen();
        accountStage.show();
    }

    /**
     * The entry point of class LoginDialog
     *
     * @param args the input arguments
     */

    public void setTextField(Button button,Text text, TextField field, String whichProperty) {
        button.setOnAction(event -> {
            if (event.getSource() == button) {
                text.setManaged(false);
                text.setVisible(false);

                field.setPromptText(getProperty(whichProperty));
                field.setManaged(true);
                field.setVisible(true);
            }
        });

        field.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER) {
                field.setManaged(false);
                field.setVisible(false);

                setProperty(whichProperty, field.getText());
                text.setText(getProperty(whichProperty));

                text.setManaged(true);
                text.setVisible(true);
            }
        });
    }

    public void setDateField(Button button,Text text, DatePicker picker, String whichProperty) {
        button.setOnAction(event -> {
            if (event.getSource() == button) {
                text.setManaged(false);
                text.setVisible(false);

                picker.setPromptText(getProperty(whichProperty));
                picker.setManaged(true);
                picker.setVisible(true);
            }
        });

        picker.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER) {
                picker.setManaged(false);
                picker.setVisible(false);

                java.sql.Date newDate = Date.valueOf(picker.valueProperty().get());
                selectedUser.setBirthday(newDate);

                var newProperty = picker.valueProperty().get().toString().toLowerCase();
                text.setText(newProperty);

                text.setManaged(true);
                text.setVisible(true);
            }
        });
    }

    public String getProperty(String whichProperty) {
        if (whichProperty == "Login") {
            return selectedUser.getLogin();
        }
        else if (whichProperty == "Forename") {
            return selectedUser.getForename();
        }
        else if (whichProperty == "Surname") {
            return selectedUser.getSurname();
        }
        else if (whichProperty == "Pesel") {
            return selectedUser.getPesel();
        }
        else if (whichProperty == "Contact Number") {
            return selectedUser.getPhoneNumber();
        }
        else if (whichProperty == "Birthday") {
            //return createStringConverter().fromString(selectedUser.getBirthday().toString());
            return selectedUser.getBirthday().toString();
        }
        return "";
    }

    public void setProperty(String whichProperty, String newProperty) {
        if (whichProperty == "Login") {
            selectedUser.setLogin(newProperty);
        } else if (whichProperty == "Forename") {
            selectedUser.setForename(newProperty);
        } else if (whichProperty == "Surname") {
            selectedUser.setSurname(newProperty);
        } else if (whichProperty == "Pesel") {
            selectedUser.setPesel(newProperty);
        } else if (whichProperty == "Contact Number") {
            selectedUser.setPhoneNumber(newProperty);
        } else if (whichProperty == "Birthday") {
            Date d = Date.valueOf(newProperty);
            selectedUser.setBirthday(d);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
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
