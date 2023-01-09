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
import src.appActions.LoginWindowActions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

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
import src.appActions.LoginWindowActions;

import java.util.List;
import java.util.Vector;
import javafx.util.StringConverter;
import org.hibernate.annotations.Check;
import src.appActions.VisitsWindowActions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import src.logic.*;

/**
 * The type Registration dialog.
 */
public class AddCaptainDialog extends Application implements EventHandler<ActionEvent> {

    private GridPane grid;

    private Text formTitle, notification;

    private Label  forenameLabel, surnameLabel, peselLabel;

    private TextField forenameField, surnameField, peselField;

    private final String pattern = "dd/MM/yy";

    private CheckBox showPass, showPassConf;
    private Button accountButton, registerButton;

    private Scene scene;

    private Stage registrationStage;

    private Stage previousStage;

    private AllUsersEntity currentUser;

    private PortsEntity currentPort;

    private ShipsEntity currentShip;

    private String cssPath;

    private List<String> messages=  List.of("Required fields are empty!", "Wrong format of pesel!",
            "Successful action, you added new Captain!");

    public Vector<String> getTextContents(){
        Vector<String> data = new Vector<>();
        data.add(forenameField.getText());
        data.add(surnameField.getText());
        data.add(peselField.getText());
        return data;
    }

    @Override
    public void start(Stage stage) {
    }

    public void start(Stage tempPreviousStage, AllUsersEntity user, PortsEntity port, ShipsEntity ship) {
        previousStage = tempPreviousStage;

        Stage stage = new Stage();
        registrationStage = stage;

        previousStage.hide();

        currentUser = user;
        currentPort = port;
        currentShip = ship;
        stage.setTitle("Add Captain Dialog");
        stage.getIcons().add(
                new Image(
                        WelcomeDialog.class.getResourceAsStream("Logo.png")));

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        formTitle = new Text("Add Captain Form");
        formTitle.setId("formatTitle");
        grid.add(formTitle, 0, 0, 2, 1);

        accountButton = new Button("Account Details");
        accountButton.setPrefSize(150, 50);
        accountButton.setOnAction(this);

        grid.add(accountButton, 2, 0);
        grid.setHalignment(accountButton, HPos.RIGHT);


        showPass = new CheckBox("I'm the Captain of the ship");
        grid.add(showPass, 0, 1);

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e)
            {
                if (showPass.isSelected()) {
                    showPass.setVisible(false);
                    forenameField.setText(currentUser.getForename());
                    surnameField.setText(currentUser.getSurname());
                    peselField.setText(currentUser.getPesel());
                }
            }
        };
        showPass.setOnAction(event);

        forenameLabel = new Label("Forename: ");
        grid.add(forenameLabel, 0, 3);

        forenameField = new TextField();
        grid.add(forenameField, 1, 3);

        surnameLabel = new Label("Surname: ");
        grid.add(surnameLabel, 0, 5);

        surnameField = new TextField();
        grid.add(surnameField, 1, 5
        );

        peselLabel = new Label("Pesel: ");
        grid.add(peselLabel, 0, 7);

        peselField = new TextField();
        grid.add(peselField, 1, 7);


        registerButton = new Button("Add Captain");
        registerButton.setPrefSize(150, 50);
        registerButton.setOnAction(this);

        grid.add(registerButton, 2, 9);
        grid.setHalignment(registerButton, HPos.RIGHT);

        notification = new Text();
        notification.setId("notification");
        grid.add(notification, 1, 10);

        scene = new Scene(grid, 600, 575);
        cssPath = this.getClass().getResource("LoginDialog.css").toExternalForm();
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
        if (event.getSource() == accountButton) {
            //notification.setText("account button pressed");
            @Deprecated
            AccountDialog accountDialog = new AccountDialog();
            accountDialog.start(registrationStage, currentUser);
        }
        else if (event.getSource() == registerButton) {

            registerButton.setText("Button pressed");
            VisitsWindowActions action = new VisitsWindowActions();
            int message_code = action.addCaptian(getTextContents());
            notification.setText(messages.get(message_code));
            if(message_code == 2) {

                Vector<String> data = getTextContents();
                CaptainsEntity newCaptain = new CaptainsEntity(data.get(0), data.get(1), data.get(2));

                Stage stage = new Stage();
                CreateVisitDialog createVisitDialog = new CreateVisitDialog();

                createVisitDialog.start(stage, currentUser, currentPort, currentShip, newCaptain);
                registrationStage.close();
            }
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
