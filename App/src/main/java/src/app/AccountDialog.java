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
    private Button setUserLoginButton, setUserPassButton, setUserForenameButton, setUserSurnameButton, setUserPseselButton, setUserPeselButton, setUserBirthdayButton, setUserContactNumberButton;
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
        grid.add(userLoginText, 1, 0);

        setUserLoginButton = new Button("Change login");
        grid.add(setUserLoginButton, 2, 0);

        userPassLabel = new Label("Password: ");
        grid.add(userPassLabel, 0, 2);

        userPassText = new Text(user.getUserPassword());
        grid.add(userPassText, 1, 2);

        setUserPassButton = new Button("Change Password");
        grid.add(setUserPassButton, 0, 2);


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
