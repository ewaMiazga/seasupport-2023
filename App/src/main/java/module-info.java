module src.app {
    requires javafx.controls;
    requires javafx.fxml;


    opens src.app to javafx.fxml;
    exports src.app;
}