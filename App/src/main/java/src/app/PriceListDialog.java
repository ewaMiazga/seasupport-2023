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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Pair;

public class PriceListDialog extends Application implements EventHandler<ActionEvent> {
    private GridPane grid;
    private Text formTitle, notification;
    private TableView<Pair<String, Integer>> priceListView;
    private Button returnButton;
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

    public void start(Stage stage, String port) {
        stage.setTitle("Port: " + port + ", price list");

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        formTitle = new Text("Price List");
        formTitle.setId("formatTitle");
        grid.add(formTitle, 0, 0, 2, 1);

        returnButton = new Button("Return");
        returnButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getSource().equals(returnButton)) {
                    PortDialog portDialog = new PortDialog();
                    portDialog.start(stage, port);
                }

            }
        });

        grid.add(returnButton, 1, 2);
        grid.setHalignment(returnButton, HPos.RIGHT);

        priceListView = new TableView<Pair<String, Integer>>();

        TableColumn nameServiceCol = new TableColumn("Name of service");
        nameServiceCol.setMinWidth(160);
        nameServiceCol.setCellValueFactory(
                new PropertyValueFactory<Pair<String, Integer>, String>("name"));
        TableColumn priceCol = new TableColumn("Price (ZL)");
        priceCol.setMinWidth(100);
        priceCol.setCellValueFactory(
                new PropertyValueFactory<Pair<String, Integer>, String>("name"));
        //klasy jeden port
        //priceListView.setEditable(true);
        //priceListView.getSelectionModel().setCellSelectionEnabled(true);
        priceListView.getColumns().addAll(nameServiceCol, priceCol);

        //priceListView.getItems().addAll("Usluga1", "Usluga2", "Usluga3");
        priceListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        grid.add(priceListView, 1, 1);

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
