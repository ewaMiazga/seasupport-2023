package src.app;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Pair;
import src.logic.AllUsersEntity;
import src.logic.PortsEntity;

public class OpenDocksDialog extends Application implements EventHandler<ActionEvent> {
    private GridPane grid;
    private Text formTitle, notification;
    private Label yachtLength;
    private Button smallShipsButton, bigShipsButton, returnButton;

    private AllUsersEntity selectedUser;
    private Scene scene;
    private String cssPath;

    private final ObservableList<PortsEntity> data =
            FXCollections.observableArrayList(
                    new PortsEntity()
            );

    @Override
    public void start(Stage stage) {
    }

    public void start(Stage stage, PortsEntity port, AllUsersEntity user) {
        selectedUser = user;
        stage.setTitle("Port: " + port.getPortName() + ",open docks");
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

        yachtLength = new Label("Yacht with hull length:");
        grid.add(yachtLength, 0, 1);

        smallShipsButton = new Button("Up to 12 meters");
        smallShipsButton.setPrefSize(400, 50);
        smallShipsButton.setOnAction(this);

        grid.add(smallShipsButton, 0, 2);
        grid.setHalignment(smallShipsButton, HPos.LEFT);


        bigShipsButton = new Button("Over 12 meters");
        bigShipsButton.setPrefSize(400, 50);
        bigShipsButton.setOnAction(this);

        grid.add(bigShipsButton, 0, 3);
        grid.setHalignment(bigShipsButton, HPos.LEFT);

        returnButton = new Button("Return");
        returnButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getSource().equals(returnButton)) {
                    PortDialog portDialog = new PortDialog();
                    portDialog.start(stage, port, selectedUser);
                }

            }
        });

        grid.add(returnButton, 0, 4);
        grid.setHalignment(returnButton, HPos.RIGHT);

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
    public void handle(ActionEvent event) {
    }
}