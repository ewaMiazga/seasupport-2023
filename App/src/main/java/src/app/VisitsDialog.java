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
import javafx.stage.Stage;
import src.logic.AllUsersEntity;
import src.logic.VisitsEntity;

import java.util.*;

public class VisitsDialog extends Application implements EventHandler<ActionEvent> {
    private GridPane grid;
    private Text formTitle, notification;
    private Label visitNumberLabel;
    private Text userLoginText, userPassText, userForenameText, userSurnameText, userPeselText, userBirthdayText, userContactNumberText, userTypeText;
    private Button setUserLoginButton, setUserPassButton, setUserForenameButton, setUserSurnameButton, setUserPeselButton, setUserBirthdayButton, setUserContactNumberButton;
    private Button returnButton;
    private TextField userLoginField, userPassField, userForenameField, userSurnameField, userPeselField, userContactNumberField;
    private DatePicker birthdayPicker;
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
    private Label userOldPassLabel,userPassLabel, userPassConfLabel;
    private TextField userOldPassVisibleField, userPassVisibleField, userPassConfVisibleField;
    private PasswordField userOldPassField, userPassField, userPassConfField;
    private CheckBox showOldPass, showPass, showConfPass;
    private Button changePassButton;
    private Scene scene;
    private Stage changePassStage;
    private String cssPath;

    @Override
    public void start(Stage stage) {
        changePassStage = stage;
        stage.setTitle("Change Password Dialog");
        stage.getIcons().add(
                new Image(
                        WelcomeDialog.class.getResourceAsStream("Logo.png")));

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        userOldPassLabel = new Label("Enter old Password: ");
        grid.add(userOldPassLabel, 0, 1);

        userOldPassVisibleField = new TextField();
        userOldPassVisibleField.setManaged(false);
        userOldPassVisibleField.setVisible(false);

        showOldPass = new CheckBox("Show password");
        showOldPass.setAlignment(Pos.CENTER_RIGHT);
        grid.add(showOldPass, 1, 2);

        userOldPassField = new PasswordField();
        showPassword(userOldPassField, userOldPassVisibleField, showOldPass);

        grid.add(userOldPassField, 1, 1);
        grid.add(userOldPassVisibleField, 1,1);

        userPassLabel = new Label("Enter new Password: ");
        grid.add(userPassLabel, 0, 3);

        userPassVisibleField = new TextField();
        userPassVisibleField.setManaged(false);
        userPassVisibleField.setVisible(false);

        showPass = new CheckBox("Show password");
        showPass.setAlignment(Pos.CENTER_RIGHT);
        grid.add(showPass, 1, 4);

        userPassField = new PasswordField();
        showPassword(userPassField, userPassVisibleField, showPass);

        grid.add(userPassField, 1, 3);
        grid.add(userPassVisibleField, 1, 3);


        userPassConfLabel = new Label("Repeat new Password: ");
        grid.add(userPassConfLabel, 0, 5);

        userPassConfVisibleField = new TextField();
        userPassConfVisibleField.setManaged(false);
        userPassConfVisibleField.setVisible(false);

        showConfPass = new CheckBox("Show password");
        showConfPass.setAlignment(Pos.CENTER_RIGHT);
        grid.add(showConfPass, 1, 6);

        userPassConfField = new PasswordField();
        showPassword(userPassConfField, userPassConfVisibleField, showConfPass);

        grid.add(userPassConfField, 1, 5);
        grid.add(userPassConfVisibleField, 1, 5);

        changePassButton = new Button("Change Password");

        changePassButton.setOnAction(event -> {
            if (!userOldPassField.getText().equals(selectedUser.getUserPassword().toString())) {
                notification.setText("Old password is incorrect!");
                return;
            }
            else if (!userPassField.getText().equals(userPassConfField.getText())) {
                notification.setText("Passwords are different!");
                return;
            }
            else if (event.getSource() == changePassButton) {
                selectedUser.setUserPassword(userPassField.getText());
                userPassText.setText(selectedUser.getUserPassword().toString());

                changePassStage.close();
            }
        });

        grid.add(changePassButton, 1, 7);
        grid.setHalignment(changePassButton, HPos.RIGHT);

        notification = new Text();
        notification.setId("notification");
        grid.add(notification, 1, 8);

        scene = new Scene(grid, 400, 275);
        cssPath = this.getClass().getResource("LoginDialog.css").toExternalForm();
        scene.getStylesheets().add(cssPath);
        changePassStage.setScene(scene);
        changePassStage.centerOnScreen();
        changePassStage.show();
    }

    public void showPassword(PasswordField field, TextField text, CheckBox box) {
        text.managedProperty().bind(box.selectedProperty());
        text.visibleProperty().bind(box.selectedProperty());

        field.managedProperty().bind(box.selectedProperty().not());
        field.visibleProperty().bind(box.selectedProperty().not());

        text.textProperty().bindBidirectional(field.textProperty());
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