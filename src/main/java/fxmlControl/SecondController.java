package fxmlControl;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SecondController {

        @FXML
        private Button btn1;
        public void initialize(){
            btn1.setOnAction(event -> {
                try {
                    switchToMainScreen(event);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        @FXML
        void switchToMainScreen(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
            Parent root = loader.load();
            MainController mainController = loader.getController();

            // Access any methods or data in the second screen controller if needed
            // secondScreenController.someMethod();

            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        }
    }
