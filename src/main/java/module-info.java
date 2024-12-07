module org.example.fxmlcontrol {
    requires javafx.controls;
    requires javafx.fxml;


    opens fxmlControl to javafx.fxml;
    exports fxmlControl;
}