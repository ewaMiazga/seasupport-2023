module src.app {
    requires javafx.controls;
    requires javafx.fxml;

    opens src.app to javafx.fxml;
    requires jakarta.persistence;
    exports src.app;
    requires org.hibernate.orm.core;
    requires com.oracle.database.jdbc;
    requires java.naming;
//    requires org.hibernate.commons.annotations;
}