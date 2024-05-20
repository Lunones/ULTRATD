module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.xml.bind;

    opens org.example to javafx.fxml;
    opens org.example.model.connection to java.xml.bind;
    exports org.example;
    exports org.example.view;
    opens org.example.view to javafx.fxml;
}
