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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import src.logic.PortsEntity;

import java.io.IOException;

import static java.lang.String.valueOf;

public class ContactDialog extends Application implements EventHandler<ActionEvent> {
    private GridPane grid;
    private Text formTitle, notification;

    private Label addressLabel, contactNumberLabel, vhfChannelLabel, bankAccountLabel;

    private Text streetNumberText, streetNameText, cityNameText, postCodeText, contactNumberText,vhfChannelText, bankAccountText;
    private Button returnButton;
    private Scene scene;
    private Stage contactStage;
    private String cssPath;

    @Override
    public void start(Stage stage) {
    }

    public void start(Stage stage, PortsEntity port) {
        contactStage = stage;
        stage.setTitle("Map Dialog");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        formTitle = new Text(port.getPortName());
        formTitle.setId("formatTitle");
        grid.add(formTitle, 0, 0, 2, 1);

        addressLabel = new Label("Address: ");
        grid.add(addressLabel, 0, 1);

        streetNumberText = new Text(valueOf(port.getStreetNumber()));
        streetNameText = new Text(port.getStreetName());

        cityNameText = new Text(port.getCityName());
        postCodeText = new Text(port.getPostCode());

        Text comaText = new Text(",");
        Text countryText = new Text("Poland");
        Text[] address = {streetNameText, streetNumberText, comaText, postCodeText, cityNameText, countryText};

        Text portAdress = new Text();
        for (Text s : address) {
            portAdress.setText(portAdress.getText() + " " + s.getText());
        }
        grid.add(portAdress, 1, 1);

        contactNumberLabel = new Label("Contact Number: ");
        grid.add(contactNumberLabel, 0, 2);

        contactNumberText = new Text(valueOf(port.getPhoneNumber()));
        grid.add(contactNumberText, 1, 2);

        vhfChannelLabel = new Label("VHF Channel: ");
        grid.add(vhfChannelLabel, 0, 3);

        vhfChannelText = new Text(valueOf(port.getVhfChannel()));
        grid.add(vhfChannelText, 1, 3);

        bankAccountLabel = new Label("Bank account: ");
        grid.add(bankAccountLabel, 0, 4);

        bankAccountText = new Text(valueOf(port.getBankAccount()));
        grid.add(bankAccountText, 1, 4);


        returnButton = new Button("Return");
        returnButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getSource().equals(returnButton)) {
                    PortDialog portDialog = new PortDialog();
                    portDialog.start(stage, port);
                }

            }
        });

        grid.add(returnButton, 1, 5);
        grid.setHalignment(returnButton, HPos.RIGHT);

        notification = new Text();
        notification.setId("notification");
        grid.add(notification, 0, 6);

        scene = new Scene(grid, 600, 575);
        cssPath = this.getClass().getResource("LoginDialog.css").toExternalForm();
        scene.getStylesheets().add(cssPath);
        contactStage.setScene(scene);
        contactStage.centerOnScreen();
        contactStage.show();
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

