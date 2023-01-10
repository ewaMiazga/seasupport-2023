package src.app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import src.logic.AllUsersEntity;
import src.logic.VisitsEntity;

import java.util.*;

public class VisitsDialog extends Application implements EventHandler<ActionEvent> {
    private GridPane grid;
    private Text formTitle, notification;
    private Button returnButton;

    private AllUsersEntity selectedUser;

    private final String pattern = "dd/MM/yy";
    private Scene scene;

    private Stage visitsStage;
    private String cssPath;

    @Override
    public void start(Stage stage) {
    }

    public void start(Stage previousStage, AllUsersEntity user) {
        Stage stage = new Stage();
        visitsStage = stage;

        previousStage.hide();

        selectedUser = user;
        stage.setTitle("Visits Dialog");
        stage.getIcons().add(
                new Image(
                        WelcomeDialog.class.getResourceAsStream("Logo.png")));

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.getColumnConstraints().add(new ColumnConstraints(150));
        grid.getColumnConstraints().add(new ColumnConstraints(150));
        grid.getColumnConstraints().add(new ColumnConstraints(200));


        formTitle = new Text("Your visits: ");
        formTitle.setId("formatTitle");
        grid.add(formTitle, 0, 0, 1, 2);
        grid.setHalignment(formTitle, HPos.CENTER);

        Collection<VisitsEntity> visits = selectedUser.getVisitsEntities();
        ArrayList<VisitsEntity> visitsList = new ArrayList<>(visits);

        for (int i = 0; i < visitsList.size(); i++) {
            Label visitNumberLabel = new Label(String.valueOf(i + 1) + ".");
            visitNumberLabel.setFont(Font.font(30));
            grid.add(visitNumberLabel, 0, i + 2);

            Button endVisitButton = new Button("End this visit");
            endVisitButton.setPrefSize(150, 25);
            grid.add(endVisitButton, 2, i + 2);
            grid.setHalignment(endVisitButton, HPos.CENTER);

            endVisitButton.setOnAction(event -> {
                Stage tempStage = new Stage();
                ConfirmEndVistDialog confirmEndVistDialog = new ConfirmEndVistDialog();
                confirmEndVistDialog.start(tempStage);
            });

            Label dateBeginLabel = new Label("date begin: ");
            grid.add(dateBeginLabel, 0, i + 3);

            Text dateBeginText = new Text(visitsList.get(i).getDateBegin().toString());
            grid.add(dateBeginText, 1, i + 3);

            Label dateEndLabel = new Label("date end: ");
            grid.add(dateEndLabel, 0, i + 4);

            Text dateEndText = new Text(visitsList.get(i).getDateEnd().toString());
            grid.add(dateEndText, 1, i + 4);

            Label portNameLabel = new Label("Port name: ");
            grid.add(portNameLabel, 0, i + 5);

            Text portNameText = new Text(visitsList.get(i).getPortsEntity().getPortName());
            grid.add(portNameText, 1, i + 5);

            Label shipNameLabel = new Label("Ship name: ");
            grid.add(shipNameLabel, 0, i + 6);

            Text shipNameText = new Text(visitsList.get(i).getShipsEntity().getShipName());
            grid.add(shipNameText, 1, i + 6);

            Label captainNameLabel = new Label("Captain name: ");
            grid.add(captainNameLabel, 0, i + 7);

            Text captainNameText = new Text(visitsList.get(i).getCaptainsEntity().getForename() + " " +
                    visitsList.get(i).getCaptainsEntity().getSurname());
            grid.add(captainNameText, 1, i + 7);
        }

        returnButton = new Button("return");
        returnButton.setPrefSize(150, 50);
        returnButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getSource().equals(returnButton)) {
                    previousStage.show();
                    stage.hide();
                }

            }
        });

        grid.add(returnButton, 2, visitsList.size() * 4 + 4);
        grid.setHalignment(returnButton, HPos.CENTER);

        notification = new Text();
        notification.setId("notification");
        grid.add(notification, 1, 6);

        //ScrollPane sp = new ScrollPane(grid);
        //grid.add(sp, 0, 1);
        //grid.setHgrow(sp, Priority.ALWAYS);
        //sp.setFitToWidth(true);

        scene = new Scene(grid, 600, 575);
        cssPath = this.getClass().getResource("LoginDialog.css").toExternalForm();
        scene.getStylesheets().add(cssPath);
        visitsStage.setScene(scene);
        visitsStage.centerOnScreen();
        visitsStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
    }



class ConfirmEndVistDialog extends Application {
    private GridPane grid;
    private Text notification;
    private Label areYouSureLabel;
    private Button yesButton, noButton;
    private Scene scene;
    private Stage confirmEndVisitStage;
    private String cssPath;

    @Override
    public void start(Stage stage) {
        confirmEndVisitStage = stage;
        stage.setTitle("Confirm the end of the visit Dialog");
        stage.getIcons().add(
                new Image(
                        WelcomeDialog.class.getResourceAsStream("Logo.png")));

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        formTitle = new Text("Are you sure you want to finish this visit?");
        formTitle.setWrappingWidth(350);
        formTitle.setTextAlignment(TextAlignment.CENTER);
        formTitle.setId("formatTitle");
        grid.add(formTitle, 0, 0, 3, 2);
        grid.setHalignment(formTitle, HPos.CENTER);


        yesButton = new Button("Yes, I want to end this visit");
        yesButton.setWrapText(true);
        yesButton.setTextAlignment(TextAlignment.CENTER);
        grid.add(yesButton, 0, 3, 1, 2);
        yesButton.setPrefSize(200, 50);


        yesButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getSource().equals(yesButton)) {
                    confirmEndVisitStage.close();
                }

            }
        });

        noButton = new Button("No, return to my visits");
        noButton.setTextAlignment(TextAlignment.CENTER);
        noButton.setWrapText(true);
        grid.add(noButton, 1, 3, 1, 2);
        noButton.setPrefSize(200, 50);
        noButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getSource().equals(noButton)) {
                    confirmEndVisitStage.close();
                }

            }
        });

        notification = new Text();
        notification.setId("notification");
        grid.add(notification, 1, 8);

        scene = new Scene(grid, 400, 275);
        cssPath = this.getClass().getResource("LoginDialog.css").toExternalForm();
        scene.getStylesheets().add(cssPath);
        confirmEndVisitStage.setScene(scene);
        confirmEndVisitStage.centerOnScreen();
        confirmEndVisitStage.show();
    }


    /**
     * The entry point of class LoginDialog
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

    public List<Node> getNodesByCoordinate(Integer row, Integer column) {
        List<Node> matchingNodes = new ArrayList<>();
        for (Node node : grid.getChildren()) {
            if(grid.getRowIndex(node) == row && grid.getColumnIndex(node) == column && (node instanceof TextField || node instanceof CheckBox || node instanceof DatePicker)){
                matchingNodes.add(node);
            }
        }
        return matchingNodes;
    }

    public void handleArrowNavigation(KeyEvent event) {
        Node source = (Node) event.getSource(); // the GridPane
        Node focused = source.getScene().getFocusOwner();
        if (event.getCode().isArrowKey() && focused.getParent() == source) {

            int row = grid.getRowIndex(focused);
            int col = grid.getColumnIndex(focused);
            // Switch expressions were standardized in Java 14
            switch (event.getCode()) {
                case LEFT: {
                    if (col < grid.getColumnCount() - 1) {
                        List<Node> newFocused = getNodesByCoordinate(row, col + 1);
                        if(newFocused.size() > 0)
                            newFocused.get(0).requestFocus();
                    }
                }
                break;
                case RIGHT: {
                    if (col > 0) {
                        List<Node> newFocused = getNodesByCoordinate(row, col - 1);
                        if(newFocused.size() > 0)
                            newFocused.get(0).requestFocus();
                    }
                }
                break;
                case UP: {
                    if (row > 0) {
                        List<Node> newFocused = getNodesByCoordinate(row - 1, col);
                        if(newFocused.size() > 0)
                            newFocused.get(0).requestFocus();
                    }
                }
                break;
                case DOWN: {
                    if (row < grid.getRowCount() - 1) {
                        List<Node> newFocused = getNodesByCoordinate(row + 1, col);
                        if(newFocused.size() > 0)
                            newFocused.get(0).requestFocus();
                    }
                }break;
            }
            event.consume();
        }
    }


}