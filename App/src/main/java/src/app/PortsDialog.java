package src.app;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import src.logic.PortsEntity;

/**
 * The type Ports dialog.
 */
public class PortsDialog extends Application implements EventHandler<MouseEvent> {
    private GridPane grid;
    private Text formTitle, notification;

    private TableView<PortsEntity> tableView;

    private final ObservableList<PortsEntity> data =
            FXCollections.observableArrayList(
                    new PortsEntity()
            );

    private Button mouseButton, settingsButton;
    private Scene scene;

    private String cssPath;
    @Override
    public void start(Stage stage) {
        stage.setTitle("Ports Dialog");
        stage.getIcons().add(
                new Image(
                        WelcomeDialog.class.getResourceAsStream("Logo.png")));

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        formTitle = new Text("Choose Port");
        formTitle.setId("formatTitle");
        grid.add(formTitle, 0, 0, 2, 1);

        settingsButton = new Button("Settings");
        settingsButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getSource().equals(settingsButton)) {
                    LoginDialog loginDialog = new LoginDialog();
                    loginDialog.start(stage);
                }

            }
        });

        grid.add(settingsButton, 1, 0);
        grid.setHalignment(settingsButton, HPos.RIGHT);

        tableView = new TableView<PortsEntity>();
        tableView.setEditable(true);
        TableColumn portNameCol = new TableColumn<String, String>("Port Name");
        portNameCol.setMinWidth(260);
        portNameCol.setCellValueFactory(
                new PropertyValueFactory<PortsEntity, String>("portName"));
        tableView.setItems(data);
        tableView.getColumns().addAll(portNameCol);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        grid.add(tableView, 1, 1);

        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {
                    //Use ListView's getSelected Item
                    PortsEntity currentItemSelected = tableView.getSelectionModel()
                            .getSelectedItem();
                    //Parent parent = LoginDialog
                    //e->stage.setScene();
                    System.out.println(currentItemSelected.getPortName());
                    PortDialog portDialog = new PortDialog();
                    portDialog.start(stage, currentItemSelected);

                }
            }
        });


        notification = new Text();
        notification.setId("notification");
        grid.add(notification, 1, 6);

        scene = new Scene(grid, 600, 575);
        cssPath = this.getClass().getResource("PortsDialog.css").toExternalForm();
        scene.getStylesheets().add(cssPath);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
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
    public void handle(MouseEvent mouseEvent) {
    }
}
