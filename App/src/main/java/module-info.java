module src.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens src.app to javafx.fxml;
    requires jakarta.persistence;
    exports src.app;
    requires org.hibernate.orm.core;
    requires com.oracle.database.jdbc;
    requires java.naming;
    opens src.logic to org.hibernate.orm.core;
//    requires org.hibernate.commons.annotations;
}