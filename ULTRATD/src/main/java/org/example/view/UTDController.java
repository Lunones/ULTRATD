package org.example.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.example.App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class UTDController extends Controller implements Initializable {

    // Field to hold a reference to the LoginController
    private LoginController controller;

    // Method called by FXMLLoader when initializing the controller
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialization code can be added here
    }

    // Method called when opening this scene
    @Override
    public void onOpen(Object input) throws IOException {
        // Cast the input object to LoginController and store it
        this.controller = (LoginController) input;
    }

    // Method called when closing this scene
    @Override
    public void onClose(Object output) {
        // Cleanup code can be added here
    }

    // Event handler method for the Quit button
    @FXML
    void Quit(ActionEvent event) throws IOException {
        // Change the scene to the LOGIN scene
        App.currentController.changeScene(Scenes.LOGIN, null);
    }

    // Event handler method for the Collect button
    @FXML
    void Collect(ActionEvent event) throws IOException {
        // Change the scene to the UNDERCONST scene
        App.currentController.changeScene(Scenes.UNDERCONST, null);
    }

    // Event handler method for the Credits button
    @FXML
    void Credits(ActionEvent event) throws IOException {
        // Change the scene to the UNDERCONST scene
        App.currentController.changeScene(Scenes.UNDERCONST, null);
    }

    // Event handler method for the Options button
    @FXML
    void Options(ActionEvent event) throws IOException {
        // Change the scene to the UNDERCONST scene
        App.currentController.changeScene(Scenes.UNDERCONST, null);
    }

    // Event handler method for the PlayTheGame button
    @FXML
    void PlayTheGame(ActionEvent event) throws IOException {
        // Change the scene to the UNDERCONST scene
        App.currentController.changeScene(Scenes.UNDERCONST, null);
    }

}

