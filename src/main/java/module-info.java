module com.example.kantineprojekt {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;

    opens com.example.kantineprojekt to javafx.fxml;
    exports com.example.kantineprojekt;
    exports Model;
    opens Model to javafx.fxml;
    exports com.example.kantineprojekt.Controller;
    opens com.example.kantineprojekt.Controller to javafx.fxml;
}