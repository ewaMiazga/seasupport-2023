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

import java.util.List;
import java.util.Vector;

import src.appActions.VisitsWindowActions;


/**
 * The type Add Owner dialog.
 */
public class AddOwnerDialog extends Application implements EventHandler<ActionEvent> {

    private GridPane grid;
    private Text formTitle, notification;
    private Label forenameLabel, surnameLabel, phoneLabel, emailLabel, peselLabel, ownerTypeLabel,
            companyLabel, nipLabel, extraInfoLabel;
    private TextField  forenameField, surnameField, phoneField, emailField, peselField, companyField, nipField;

    ComboBox<String> types;

    private String ownerTypes [] = {  "Private", "Commercial" };

    private final String pattern = "dd/MM/yy";

    private Button registerButton;

    private Scene scene;

    private Stage registrationStage;

    private String cssPath;

    private List<String> messages=  List.of("Required fields are empty!"
             ,"Wrong format of phone number!", "Wrong format of email!", "Wrong format of pesel!",
            "Wrong format of NIP number","Successful action, you added new owner!");

    public Vector<String> getTextContents(){
        Vector<String> data = new Vector<>();
        data.add(forenameField.getText());
        data.add(surnameField.getText());
        data.add(phoneField.getText());
        data.add(emailField.getText());
        data.add(peselField.getText());
        data.add("Private");
        data.add(companyField.getText());
        data.add(nipField.getText());
        return data;
    }
    @Override
    public void start(Stage stage) {
        registrationStage = stage;
        stage.setTitle("Add Owner Dialog");
        stage.getIcons().add(
                new Image(
                        WelcomeDialog.class.getResourceAsStream("Logo.png")));

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        formTitle = new Text("Add Owner Form");
        formTitle.setId("formatTitle");
        grid.add(formTitle, 0, 0, 2, 1);

        forenameLabel = new Label("Forename: ");
        grid.add(forenameLabel, 0, 1);

        forenameField = new TextField();
        grid.add(forenameField, 1, 1);

        surnameLabel = new Label("Surname: ");
        grid.add(surnameLabel, 0, 2);

        surnameField = new TextField();
        grid.add(surnameField, 1, 2);

        peselLabel = new Label("Pesel: ");
        grid.add(peselLabel, 0, 3);

        peselField = new TextField();
        grid.add(peselField, 1, 3);

        phoneLabel = new Label("Phone number: ");
        grid.add(phoneLabel, 0, 4);

        phoneField = new TextField();
        grid.add(phoneField, 1, 4);

        emailLabel = new Label("Email: ");
        grid.add(emailLabel, 0, 5);

        emailField = new TextField();
        grid.add(emailField, 1, 5);

        ownerTypeLabel = new Label("Owner Type: ");
        grid.add(ownerTypeLabel, 0, 6);

        ComboBox types = new ComboBox<String>();
        types.getItems().setAll(
                new String("Private"),
                new String("Commercial")
        );
        grid.add(types, 1, 6);

        extraInfoLabel = new Label("Data provided only by the commercial owners: ");
        grid.add(extraInfoLabel, 0, 9);

        companyLabel = new Label("Company name: ");
        grid.add(companyLabel, 0, 10);

        companyField = new TextField();
        grid.add(companyField, 1, 10);

        nipLabel = new Label("NIP: ");
        grid.add(nipLabel, 0, 11);

        nipField = new TextField();
        grid.add(nipField, 1, 11);

        registerButton = new Button("Add Owner");
        registerButton.setOnAction(this);

        grid.add(registerButton, 1, 12);
        grid.setHalignment(registerButton, HPos.RIGHT);

        notification = new Text();
        notification.setId("notification");
        grid.add(notification, 1, 13);

        scene = new Scene(grid, 600, 575);
        cssPath = this.getClass().getResource("LoginDialog.css").toExternalForm();
        scene.getStylesheets().add(cssPath);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The entry point of class AddOwnerDialog
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == registerButton) {

            registerButton.setText("Button pressed");
            VisitsWindowActions action = new VisitsWindowActions();
            int message_code = action.addOwner(getTextContents());
            notification.setText(messages.get(message_code));
            if(message_code == 5) {
                registrationStage.close();
            }
        }
    }
}
