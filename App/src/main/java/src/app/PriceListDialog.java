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

import java.sql.Date;

public class PriceListDialog extends Application implements EventHandler<ActionEvent> {
    private GridPane grid;
    private Text formTitle, notification;
    private TableView<Pair<String, Integer>> priceListView;
    private Button accountButton, returnButton;

    private AllUsersEntity selectedUser;

    private Stage priceListStage;
    private Scene scene;
    private String cssPath;

    private final ObservableList<Pair<String, Integer>> data = FXCollections.observableArrayList(
            new Pair("Usluga1", 12),
            new Pair("Usluga2", 10),
            new Pair("Usluga3", 15)
    );

    @Override
    public void start(Stage stage) {
    }

    public void start(Stage stage, PortsEntity port, AllUsersEntity user) {
        selectedUser = user;
        priceListStage = stage;
        stage.setTitle("Port: " + port.getPortName() + ", price list");
        stage.getIcons().add(
                new Image(
                        WelcomeDialog.class.getResourceAsStream("Logo.png")));
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        accountButton = new Button("Account Details");
        accountButton.setPrefSize(150, 50);
        accountButton.setOnAction(this);

        grid.add(accountButton, 1, 0);
        grid.setHalignment(accountButton, HPos.RIGHT);

        formTitle = new Text("Price List");
        formTitle.setId("formatTitle");
        grid.add(formTitle, 0, 0);

        returnButton = new Button("Return");
        returnButton.setPrefSize(150, 50);
        returnButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getSource().equals(returnButton)) {
                    PortDialog portDialog = new PortDialog();
                    portDialog.start(stage, port, selectedUser);
                }

            }
        });

        grid.add(returnButton, 1, 2);
        grid.setHalignment(returnButton, HPos.RIGHT);

        priceListView = new TableView<Pair<String, Integer>>();

        TableColumn nameServiceCol = new TableColumn("Name of service");
        nameServiceCol.setMinWidth(300);
        nameServiceCol.setCellValueFactory(
                new PropertyValueFactory<Pair<String, Integer>, String>("pair.getValue0()"));
        TableColumn priceCol = new TableColumn("Price (ZL)");
        priceCol.setMinWidth(200);
        priceCol.setCellValueFactory(
                new PropertyValueFactory<Pair<String, Integer>, String>("name"));
        //klasy jeden port
        //priceListView.setEditable(true);
        //priceListView.getSelectionModel().setCellSelectionEnabled(true);
        priceListView.getColumns().addAll(nameServiceCol, priceCol);

        //priceListView.getItems().addAll("Usluga1", "Usluga2", "Usluga3");

        priceListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        grid.add(priceListView, 0, 1, 2, 1);

        priceListView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {
                    //Use ListView's getSelected Item
                    //String currentItemSelected = priceListView.getSelectionModel()
                    //        .getSelectedItem();
                    //Parent parent = LoginDialog
                    //e->stage.setScene();
                    //System.out.println(currentItemSelected);
                    //PortDialog portDialog = new PortDialog();
                    //portDialog.start(stage, currentItemSelected);

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
    public void handle(ActionEvent event) {
        if (event.getSource() == accountButton) {
            notification.setText("account button pressed");
            @Deprecated
            Date d = new Date(1999, 10, 5);
            AllUsersEntity user = new AllUsersEntity("ewa", "miazga", "Ewa", "Miazga", "666999333", d, "123456789", "user");
            AccountDialog accountDialog = new AccountDialog();
            accountDialog.start(priceListStage, user);
        }
    }

    public final ObservableList<Pair<String, Integer>> setData() {
        final ObservableList<Pair<String, Integer>> data = FXCollections.observableArrayList(
                new Pair("Usluga1", 12),
                new Pair("Usluga2", 10),
                new Pair("Usluga3", 15)
        );
        return data;
    }
}
