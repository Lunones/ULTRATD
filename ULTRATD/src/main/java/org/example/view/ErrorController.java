package org.example.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;

public class ErrorController extends Controller implements Initializable {

    private LoginController controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialization code can be added here if needed
    }

    @Override
    public void onOpen(Object input) throws IOException {
        // Any necessary actions when the controller is opened can be added here
    }

    @Override
    public void onClose(Object output) {
        // Any necessary cleanup logic when the controller is closed can be added here
    }

    @FXML
    private void Error(ActionEvent event) throws IOException {
        // Method to handle the error event
        // Add any necessary logic here
    }

    @FXML
    private void Backbt(Event event) {
        // Method to handle the back button event
        // Close the current window
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
