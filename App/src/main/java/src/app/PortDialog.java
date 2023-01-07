package src.app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import src.logic.AllUsersEntity;
import src.logic.PortsEntity;
import java.sql.Date;

import java.io.IOException;

/**
 * The type Port dialog.
 *
 */
public class PortDialog extends Application implements EventHandler<ActionEvent> {
    private GridPane grid;
    private Text formTitle, notification;
    private Button accountButton, priceListButton, docksButton, mapButton, contactButton, returnButton;
    private Scene scene;
    private Stage portStage;
    private AllUsersEntity selectedUser;
    private PortsEntity selectedPort;
    private String cssPath;

    @Override
    public void start(Stage stage) {
    }

    /**
     * Start.
     *
     * @param stage the stage
     * @param port the port
     */
    public void start(Stage stage, PortsEntity port, AllUsersEntity user) {
        portStage = stage;
        selectedPort = port;
        selectedUser = user;
        stage.setTitle("Port Dialog");
        stage.getIcons().add(
                new Image(
                        WelcomeDialog.class.getResourceAsStream("Logo.png")));

        grid = new GridPane();

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        formTitle = new Text(port.getPortName());
        formTitle.setId("formatTitle");
        grid.add(formTitle, 0, 0, 2, 1);

        accountButton = new Button("Account Details");
        accountButton.setPrefSize(150, 50);
        accountButton.setOnAction(this);

        grid.add(accountButton, 1, 0);
        grid.setHalignment(accountButton, HPos.RIGHT);

        priceListButton = new Button("Price List");
        priceListButton.setPrefSize(250, 250);
        priceListButton.setOnAction(this);

        grid.add(priceListButton, 0, 1);
        grid.setHalignment(priceListButton, HPos.LEFT);

        docksButton = new Button("Open docks");
        docksButton.setPrefSize(250, 250);
        docksButton.setOnAction(this);

        grid.add(docksButton, 1, 1);
        grid.setHalignment(docksButton, HPos.RIGHT);


        mapButton = new Button("Map of the port");
        mapButton.setPrefSize(250, 250);
        mapButton.setOnAction(this);

        grid.add(mapButton, 0, 3);
        grid.setHalignment(mapButton, HPos.LEFT);


        contactButton = new Button("Contact");
        contactButton.setPrefSize(250, 250);
        contactButton.setOnAction(this);

        grid.add(contactButton, 1, 3);
        grid.setHalignment(contactButton, HPos.RIGHT);

        returnButton = new Button("Return");
        returnButton.setPrefSize(150, 50);
        returnButton.setOnAction(this);

        grid.add(returnButton, 1, 4);
        grid.setHalignment(returnButton, HPos.RIGHT);

        notification = new Text();
        notification.setId("notification");
        grid.add(notification, 1, 6);

        scene = new Scene(grid, 600, 575);
        cssPath = this.getClass().getResource("PortsDialog.css").toExternalForm();
        scene.getStylesheets().add(cssPath);
        portStage.setScene(scene);
        portStage.show();
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
        //TODO:
        //Write function, which will check if login and password are equal from those from
        //database @michał
        if (event.getSource() == accountButton) {
            notification.setText("account button pressed");
            @Deprecated
            Date d = new Date(1999, 10, 5);
            AllUsersEntity user = new AllUsersEntity("ewa", "miazga", "Ewa", "Miazga", "666999333", d, "123456789", "user");
            AccountDialog accountDialog = new AccountDialog();
            accountDialog.start(portStage, user);
        }
        else if (event.getSource() == priceListButton) {
            notification.setText("price button pressed");
            PriceListDialog priceListDialog = new PriceListDialog();
            priceListDialog.start(portStage, selectedPort, selectedUser);
        }
        else if (event.getSource() == docksButton) {
            notification.setText("docks button pressed");
            OpenDocksDialog openDocksDialog = new OpenDocksDialog();
            openDocksDialog.start(portStage, selectedPort, selectedUser);
        }
        else if (event.getSource() == mapButton) {
            notification.setText("map button pressed");
            MapDialog mapDialog = new MapDialog();
            try {
                mapDialog.start(portStage, selectedPort, selectedUser);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
        else if (event.getSource() == contactButton) {
            notification.setText("contact button pressed");
            ContactDialog contactDialog = new ContactDialog();
            contactDialog.start(portStage, selectedPort, selectedUser);
        }
        else if (event.getSource() == returnButton) {
            notification.setText("Return button pressed");
            PortsDialog portsDialog = new PortsDialog();
            portsDialog.start(portStage, selectedUser);
        }
    }

}
