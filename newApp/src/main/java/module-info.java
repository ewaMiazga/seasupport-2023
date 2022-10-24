module src.newapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens src.newapp to javafx.fxml;
    exports src.newapp;
}