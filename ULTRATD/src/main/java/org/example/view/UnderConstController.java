package org.example.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.example.App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UnderConstController extends Controller implements Initializable {

    // Method called when the controller is initialized
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialization code can be added here
    }

    // Method called when the view associated with this controller is opened
    @Override
    public void onOpen(Object input) throws IOException {
        // Any necessary setup code can be added here
    }

    // Method called when the view associated with this controller is closed
    @Override
    public void onClose(Object output) {
        // Any cleanup code can be added here
    }

    // FXML element declaration for the back button
    @FXML
    private Button backbt;

    // Event handler for the back button
    @FXML
    void back(ActionEvent event) throws IOException {
        // Navigate back to the previous scene (UTD) using the App controller
        App.currentController.changeScene(Scenes.UTD, null);
    }
}

