package src.app;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PortsDialog extends Application implements EventHandler<MouseEvent> {
    private GridPane grid;
    private Text formTitle, notification;

    private ListView<String> listView;

    private Button mouseButton, settingsButton;
    private Scene scene;

    //private Stage stage;
    @Override
    public void start(Stage stage) {
        stage.setTitle("Ports Dialog");

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

        listView = new ListView<String>();
        listView.getItems().addAll("Port1", "Port2", "Port3");
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        grid.add(listView, 1, 1);

        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {

                if (click.getClickCount() == 2) {
                    //Use ListView's getSelected Item
                    String currentItemSelected = listView.getSelectionModel()
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

        scene = new Scene(grid, 300, 275);
        stage.setScene(scene);
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
        //TODO:
        //Write function, which will check if login and password are equal from those from
        //database @michał
        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
            System.out.println(mouseEvent.getClickCount());
            if(mouseEvent.getClickCount() == 2){
                System.out.println("Double clicked");
            }
        }
    }
}
