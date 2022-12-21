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
import src.logic.AllUsersEntity;
import src.logic.PortsEntity;

import java.lang.reflect.Field;

public class AccountDialog extends Application implements EventHandler<ActionEvent> {
    private GridPane grid;
    private Text formTitle, notification;
    private Label userLoginLabel, userPassLabel, userForenameLabel, userSurnameLabel, userPeselLabel, userBirthdayLabel,  userContactNumberLabel, userTypeLabel;
    private Text userLoginText, userPassText, userForenameText, userSurnameText, userPeselText, userBirthdayText, userContactNumberText, userTypeText;
    private Button setUserLoginButton, setUserPassButton, setUserForenameButton, setUserSurnameButton, setUserPeselButton, setUserBirthdayButton, setUserContactNumberButton;

    private Button returnButton;
    private TextField userLoginField;

    private AllUsersEntity selectedUser;
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

        userLoginField.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER) {
                userLoginField.setManaged(false);
                userLoginField.setVisible(false);

                user.setLogin(userLoginField.getText());
                userLoginText.setText(user.getLogin());

                userLoginText.setManaged(true);
                userLoginText.setVisible(true);
            }
        });

        grid.add(userLoginField, 1 ,1);

        userPassLabel = new Label("Password: ");
        grid.add(userPassLabel, 0, 2);

        userPassText = new Text(user.getUserPassword());
        grid.add(userPassText, 1, 2);

        setUserPassButton = new Button("Change Password");
        setUserPassButton.setPrefSize(150, 25);
        grid.add(setUserPassButton, 2, 2);
        grid.setHalignment(setUserPassButton, HPos.CENTER);

        userForenameLabel = new Label("Forename: ");
        grid.add(userForenameLabel, 0, 3);

        userForenameText = new Text(user.getForename());
        grid.add(userForenameText, 1, 3);

        setUserForenameButton = new Button("Change Forename");
        setUserForenameButton.setPrefSize(150, 25);
        grid.add(setUserForenameButton, 2, 3);
        grid.setHalignment(setUserForenameButton, HPos.CENTER);

        userSurnameLabel = new Label("Surname: ");
        grid.add(userSurnameLabel, 0, 4);

        userSurnameText = new Text(user.getSurname());
        grid.add(userSurnameText, 1, 4);

        setUserSurnameButton = new Button("Change Surname");
        setUserSurnameButton.setPrefSize(150, 25);
        grid.add(setUserSurnameButton, 2, 4);
        grid.setHalignment(setUserSurnameButton, HPos.CENTER);

        userContactNumberLabel = new Label("Contact Number: ");
        grid.add(userContactNumberLabel, 0, 5);

        userContactNumberText = new Text(user.getPhoneNumber());
        grid.add(userContactNumberText, 1, 5);

        setUserContactNumberButton = new Button("Change Contact Number");
        setUserContactNumberButton.setPrefSize(150, 25);
        grid.add(setUserContactNumberButton, 2, 5);
        grid.setHalignment(setUserContactNumberButton, HPos.CENTER);

        userPeselLabel = new Label("Pesel: ");
        grid.add(userPeselLabel, 0, 6);

        userPeselText = new Text(user.getPesel());
        grid.add(userPeselText, 1, 6);

        setUserPeselButton = new Button("Change Pesel");
        setUserPeselButton.setPrefSize(150, 25);
        grid.add(setUserPeselButton, 2, 6);
        grid.setHalignment(setUserPeselButton, HPos.CENTER);

        userBirthdayLabel = new Label("Birthday: ");
        grid.add(userBirthdayLabel, 0, 7);

        userBirthdayText = new Text(user.getBirthday().toString());
        grid.add(userBirthdayText, 1, 7);

        setUserBirthdayButton = new Button("Change Birthday");
        setUserBirthdayButton.setPrefSize(150, 25);
        grid.add(setUserBirthdayButton, 2, 7);
        grid.setHalignment(setUserBirthdayButton, HPos.CENTER);

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
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == setUserLoginButton) {
            userLoginText.setManaged(false);
            userLoginText.setVisible(false);

            userLoginField.setPromptText(selectedUser.getLogin());
            userLoginField.setManaged(true);
            userLoginField.setVisible(true);
        }
    }

}
