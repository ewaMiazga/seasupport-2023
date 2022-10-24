module com.example.src {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.src to javafx.fxml;
    exports com.example.src;
}