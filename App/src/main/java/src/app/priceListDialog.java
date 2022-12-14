package src.app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class priceListDialog extends Application implements EventHandler<ActionEvent> {
    private GridPane grid;
    private Text formTitle, notification;
    private ListView<String> priceListView;
    private Button returnButton;
    private Scene scene;
    private String cssPath;

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

        formTitle = new Text("Choose Port");
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

        priceListView = new ListView<String>();
        priceListView.getItems().addAll("Usluga1", "Usluga2", "Usluga3");
        priceListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        grid.add(priceListView, 1, 1);

        priceListView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {
                    //Use ListView's getSelected Item
                    String currentItemSelected = priceListView.getSelectionModel()
                            .getSelectedItem();
                    //Parent parent = LoginDialog
                    //e->stage.setScene();
                    System.out.println(currentItemSelected);
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
    public void handle(ActionEvent event) {
    }
}
