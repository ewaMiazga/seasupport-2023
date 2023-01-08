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
import src.appActions.VisitsWindowActions;

import java.util.List;
import java.util.Vector;
import javafx.util.StringConverter;
import org.hibernate.annotations.Check;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * The type Add Ship Dialog.
 */
public class AddShipDialog extends Application implements EventHandler<ActionEvent> {

    private GridPane grid;

    private Text formTitle, notification;

    private Label callSignLabel, shipNameLabel, typeLabel, shipLenghtLabel, ownerIdLabel;

    private TextField callSignField, shipNameField, typeField, lenghtField, ownerIdField;

    private final String pattern = "dd/MM/yy";

    private Button registerButton, newUserButton;

    private Scene scene;

    private Stage registrationStage;

    private String cssPath;

    private List<String> messages=  List.of("Required fields are empty!", "Call Sign is not available!",
            "Incorrect type of ship!", "Length of the ship should be a number",
            "Ship is to long you can not booked place in this port",
            "Successful action, you added new ship into your account!",
            "Incorrect owner Id.");

    public Vector<String> getTextContents(){
        Vector<String> data = new Vector<>();
        data.add(callSignField.getText());
        data.add(shipNameField.getText());
        data.add(typeField.getText());
        data.add(lenghtField.getText());
        data.add(ownerIdField.getText());
        return data;
    }
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

        formTitle = new Text("Add Ship");
        formTitle.setId("formatTitle");
        grid.add(formTitle, 0, 0, 2, 1);

        callSignLabel = new Label("Call Sign: ");
        grid.add(callSignLabel, 0, 1);

        callSignField = new TextField();
        grid.add(callSignField, 1, 1);

        shipNameLabel = new Label("Ship Name: ");
        grid.add(shipNameLabel, 0, 2);

        shipNameField = new TextField();
        grid.add(shipNameField, 1, 2);

        typeLabel = new Label("Ship Type: ");
        grid.add(typeLabel, 0, 4);

        typeField = new TextField();
        grid.add(typeField, 1, 4);

        shipLenghtLabel = new Label("Ship Length: ");
        grid.add(shipLenghtLabel, 0, 6);

        lenghtField = new TextField();
        grid.add(lenghtField, 1, 6);

        ownerIdLabel = new Label("Ship Owner Id: ");
        grid.add(ownerIdLabel, 0, 8);

        ownerIdField = new TextField();
        grid.add(ownerIdField, 1, 8);

        newUserButton = new Button("Add New Owner");
        newUserButton.setOnAction(this);

        grid.add(newUserButton, 2, 8);
        grid.setHalignment(newUserButton, HPos.RIGHT);

        registerButton = new Button("Add Ship");
        registerButton.setOnAction(this);

        grid.add(registerButton, 1, 11);
        grid.setHalignment(registerButton, HPos.RIGHT);

        notification = new Text();
        notification.setId("notification");
        grid.add(notification, 1, 12);

        scene = new Scene(grid, 600, 575);
        cssPath = this.getClass().getResource("LoginDialog.css").toExternalForm();
        scene.getStylesheets().add(cssPath);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The entry point of class AddShipDialog
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == newUserButton) {
            Stage stage = new Stage();
            AddOwnerDialog ownerDialog = new AddOwnerDialog();
            ownerDialog.start(stage);
        }
        if (event.getSource() == registerButton) {

            //registerButton.setText("Add ship button pressed");
            VisitsWindowActions action = new VisitsWindowActions();
            int message_code = action.addShip(getTextContents());
            notification.setText(messages.get(message_code));
            if(message_code == 5) {
                registrationStage.close();
            }
        }
    }
}
