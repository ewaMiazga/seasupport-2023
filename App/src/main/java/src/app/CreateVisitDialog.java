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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import src.appActions.VisitsWindowActions;
import src.logic.*;

/**
 * The type CreateVisitDialog.
 */
public class CreateVisitDialog extends Application implements EventHandler<ActionEvent> {

    private GridPane grid;

    private Text formTitle, notification;

    private Label forenameLabel, surnameLabel,
            numberLabel, peselLabel, beginLabel, endLabel, captainLabel;

    private TextField forenameField, surnameField, numberField, peselField, captainField;

    private DatePicker beginPicker, endPicker;
    private final String pattern = "dd/MM/yy";
    private Button registerButton, newShipButton, newCaptainButton;

    private Scene scene;

    private Stage registrationStage;

    private String cssPath;

    private AllUsersEntity currentUser;

    private PortsEntity currentPort;

    private List<String> messages=  List.of("Required fields are empty!", "Wrong format of pesel!",
            "Visit can not start in that day!", "Visit can not end in that day!",
            "Wrong call sign of ship!","Successful operation, you added new visit in this port!", "There is no avalible places in this port.");

    public Vector<String> getTextContents(){
        Vector<String> data = new Vector<>();
        data.add(forenameField.getText());
        data.add(surnameField.getText());
        data.add(peselField.getText());
        data.add(beginPicker.toString());
        data.add(endPicker.toString());
        data.add(numberField.getText());
        return data;
    }

    @Override
    public void start(Stage stage) {
    }

    public void start(Stage stage, AllUsersEntity user, PortsEntity port) {
        registrationStage = stage;
        currentUser = user;
        currentPort = port;
        stage.setTitle("New Visit Dialog");
        stage.getIcons().add(
                new Image(
                        WelcomeDialog.class.getResourceAsStream("Logo.png")));

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


        formTitle = new Text("New Visit Form");
        formTitle.setId("formatTitle");
        grid.add(formTitle, 0, 0, 2, 1);


        beginLabel = new Label("Start date of the visit: ");
        grid.add(beginLabel, 0, 1);

        Locale.setDefault(Locale.ENGLISH);
        beginPicker = new DatePicker();
        beginPicker.setConverter(createStringConverter());
        beginPicker.setPromptText(pattern.toLowerCase());

        grid.add(beginPicker, 1, 1);

        endLabel = new Label("End date of the visit: ");
        grid.add(endLabel, 0, 3);

        Locale.setDefault(Locale.ENGLISH);
        endPicker = new DatePicker();
        endPicker.setConverter(createStringConverter());
        endPicker.setPromptText(pattern.toLowerCase());

        grid.add(endPicker, 1, 3);

        numberLabel = new Label("Ship Call Sign: ");
        grid.add(numberLabel, 0, 5);

        numberField = new TextField();
        grid.add(numberField, 1, 5);

        newShipButton = new Button("Add New Ship");
        newShipButton.setOnAction(this);

        grid.add(newShipButton, 2, 7);
        grid.setHalignment(newShipButton, HPos.RIGHT);

        captainLabel = new Label("Visit's Captian Id: ");
        grid.add(captainLabel, 0, 9);

        captainField = new TextField();
        grid.add(captainField, 1, 9);

        newCaptainButton = new Button("Add New Captian");
        newCaptainButton.setOnAction(this);

        grid.add(newCaptainButton, 2, 9);
        grid.setHalignment(newCaptainButton, HPos.RIGHT);

        registerButton = new Button("Create Visit");
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
     * The entry point of class RegistrationDialog
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == newCaptainButton) {
            Stage stage = new Stage();
            AddCaptainDialog capDialog = new AddCaptainDialog();
            capDialog.start(stage, currentUser);
        }

        if (event.getSource() == newShipButton) {

            Stage stage = new Stage();
            AddShipDialog shipDialog = new AddShipDialog();
            shipDialog.start(stage);
        }

        if (event.getSource() == registerButton) {

            registerButton.setText("Add visit button pressed");
            VisitsWindowActions action = new VisitsWindowActions();
            int message_code = action.addVisit(getTextContents(), beginPicker.getValue(), endPicker.getValue(), currentPort, currentUser);
            notification.setText(messages.get(message_code));
            if(message_code == 5) {
                PortDialog portDialog = new PortDialog();
                portDialog.start(registrationStage, currentPort, currentUser);
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
