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
import src.logic.AllUsersEntity;

public class AccountDialog extends Application implements EventHandler<ActionEvent> {
    private GridPane grid;

    private Text formTitle, notification;
    private Label userLoginLabel, userPassLabel, userForenameLabel, userSurnameLabel, userPeselLabel, userBirthdayLabel,  userContactNumberLabel, userTypeLabel;

    private Text userLoginText, userPassText, userForenameText, userSurnameText, userPeselText, userBirthdayText, userContactNumberText, userTypeText;
    private Button setUserLoginButton, setUserPassButton, setUserForenameButton, setUserSurnameButton, setUserPeselButton, setUserBirthdayButton, setUserContactNumberButton;
    private Scene scene;

    private Stage accountStage;
    private String cssPath;
    @Override
    public void start(Stage stage) {

    }
    public void start(Stage stage, AllUsersEntity user) {
        accountStage = stage;
        stage.setTitle("Account Dialog");
        stage.getIcons().add(
                new Image(
                        WelcomeDialog.class.getResourceAsStream("Logo.png")));

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        formTitle = new Text("Hi" + user.getForename());
        formTitle.setId("formatTitle");
        grid.add(formTitle, 0, 0, 1,1);
        grid.setHalignment(formTitle, HPos.CENTER);

        userLoginLabel = new Label("Login: ");
        grid.add(userLoginLabel, 0, 1);

        userLoginText = new Text(user.getLogin());
        grid.add(userLoginText, 1, 1);

        setUserLoginButton = new Button("Change login");
        grid.add(setUserLoginButton, 2, 1);

        userPassLabel = new Label("Password: ");
        grid.add(userPassLabel, 0, 2);

        userPassText = new Text(user.getUserPassword());
        grid.add(userPassText, 1, 2);

        setUserPassButton = new Button("Change Password");
        grid.add(setUserPassButton, 2, 2);

        userForenameLabel = new Label("Forename: ");
        grid.add(userForenameLabel, 0, 3);

        userForenameText = new Text(user.getForename());
        grid.add(userForenameText, 1, 3);

        setUserForenameButton = new Button("Change Forename");
        grid.add(setUserForenameButton, 2, 3);

        userSurnameLabel = new Label("Surname: ");
        grid.add(userSurnameLabel, 0, 4);

        userSurnameText = new Text(user.getSurname());
        grid.add(userSurnameText, 1, 4);

        setUserSurnameButton = new Button("Change Surname");
        grid.add(setUserSurnameButton, 2, 4);

        userContactNumberLabel = new Label("Contact Number: ");
        grid.add(userContactNumberLabel, 0, 5);

        userContactNumberText = new Text(user.getPhoneNumber());
        grid.add(userContactNumberText, 1, 5);

        setUserContactNumberButton = new Button("Change ContactNumber");
        grid.add(setUserContactNumberButton, 2, 5);

        userPeselLabel = new Label("Pesel: ");
        grid.add(userPeselLabel, 0, 6);

        userPeselText = new Text(user.getPesel());
        grid.add(userPeselText, 1, 6);

        setUserPeselButton = new Button("Change Pesel");
        grid.add(setUserPeselButton, 2, 6);

        userBirthdayLabel = new Label("Birthday: ");
        grid.add(userBirthdayLabel, 0, 7);

        userBirthdayText = new Text(user.getBirthday().toString());
        grid.add(userBirthdayText, 1, 7);

        setUserBirthdayButton = new Button("Change Birthday");
        grid.add(setUserBirthdayButton, 2, 7);

        userTypeLabel = new Label("User Type: ");
        grid.add(userTypeLabel, 0, 8);

        userTypeText = new Text(user.getUserType());
        grid.add(userTypeText, 1, 8);


        notification = new Text();
        notification.setId("notification");
        grid.add(notification, 1, 6);

        scene = new Scene(grid, 300, 275);
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

        }
    }
