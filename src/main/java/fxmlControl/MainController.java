package fxmlControl;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    TextField textField;
    @FXML
    Label label2;
    @FXML
    Button btn;
    public void initialize(){
        System.out.println("In initialize.");
        textField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            label2.setText("Длинна текста ровна " +
                    observableValue.getValue().length());
        });
        btn.setOnAction(event -> {
            try {
                switchToSecondScreen(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @FXML
    void switchToSecondScreen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("second.fxml"));
        Parent root = loader.load();
        SecondController secondController = loader.getController();

        // Access any methods or data in the second screen controller if needed
        // secondScreenController.someMethod();

       // Stage stage = (Stage) switchButton.getScene().getWindow();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }

}