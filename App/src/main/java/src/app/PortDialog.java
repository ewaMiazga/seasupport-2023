package src.app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The type Port dialog.
 *
 */
public class PortDialog extends Application implements EventHandler<ActionEvent> {
    private GridPane grid;
    private Text formTitle, notification;

    private Button detailsButton, priceListButton, docksButton, mapButton, contactButton, returnButton;

    private Button mouseButton;
    private Scene scene;
    private Stage portStage;

    private String portName;
    private String cssPath;

    @Override
    public void start(Stage stage) {
    }

    /**
     * Start.
     *
     * @param stage the stage
     * @param name the port
     */
    public void start(Stage stage, String name) {
        portStage = stage;
        portName = name;
        stage.setTitle("Port Dialog");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        formTitle = new Text(name);
        formTitle.setId("formatTitle");
        grid.add(formTitle, 0, 0, 2, 1);

        detailsButton = new Button("Port Details");
        detailsButton.setMaxSize(100, 100);
        detailsButton.setOnAction(this);

        grid.add(detailsButton, 1, 0);
        grid.setHalignment(detailsButton, HPos.RIGHT);


        priceListButton = new Button("Price List");
        priceListButton.setPrefSize(200, 200);
        priceListButton.setOnAction(this);

        grid.add(priceListButton, 0, 1);
        grid.setHalignment(priceListButton, HPos.LEFT);

        docksButton = new Button("Open docks");
        docksButton.setPrefSize(200, 200);
        docksButton.setOnAction(this);

        grid.add(docksButton, 1, 1);
        grid.setHalignment(docksButton, HPos.RIGHT);


        mapButton = new Button("Map of the port");
        mapButton.setPrefSize(200, 200);
        mapButton.setOnAction(this);

        grid.add(mapButton, 0, 3);
        grid.setHalignment(mapButton, HPos.LEFT);


        contactButton = new Button("Contact");
        contactButton.setPrefSize(200, 200);
        contactButton.setOnAction(this);

        grid.add(contactButton, 1, 3);
        grid.setHalignment(contactButton, HPos.RIGHT);

        returnButton = new Button("Return");
        returnButton.setPrefSize(100, 100);
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
        if (event.getSource() == detailsButton) {
            notification.setText("price button pressed");
            //Stage stage = new Stage();
            LoginDialog loginDialog = new LoginDialog();
            loginDialog.start(portStage);
        }
        else if (event.getSource() == priceListButton) {
            notification.setText("price button pressed");
            //Stage stage = new Stage();
            priceListDialog priceListDialog = new priceListDialog();
            priceListDialog.start(portStage, portName);
        }
        else if (event.getSource() == docksButton) {
            notification.setText("docks button pressed");
            //Stage stage = new Stage();
            RegistrationDialog registrationDialog = new RegistrationDialog();
            registrationDialog.start(portStage);
        }
        else if (event.getSource() == mapButton) {
            notification.setText("map button pressed");
            //Stage stage = new Stage();
            RegistrationDialog registrationDialog = new RegistrationDialog();
            registrationDialog.start(portStage);
        }
        else if (event.getSource() == contactButton) {
            notification.setText("contact button pressed");
            //Stage stage = new Stage();
            RegistrationDialog registrationDialog = new RegistrationDialog();
            registrationDialog.start(portStage);
        }
        else if (event.getSource() == returnButton) {
            notification.setText("Return button pressed");
            PortsDialog portsDialog = new PortsDialog();
            portsDialog.start(portStage);
        }
    }

}
