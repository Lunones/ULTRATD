package org.example.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.App;
import org.example.model.dao.FactionDAO;
import org.example.model.entity.Faction;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SearchFactionController extends Controller implements Initializable {

    // Instance variables for Faction and FactionDAO
    private Faction fact = new Faction();
    private FactionDAO Dfact = new FactionDAO();

    // Initialize method called to initialize the controller after its root element has been completely processed
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Currently, no initialization code is required
    }

    // Method called when the controller is opened
    @Override
    public void onOpen(Object input) throws IOException {
        // Currently, no specific actions are needed when the controller is opened
    }

    // Method called when the controller is closed
    @Override
    public void onClose(Object output) {
        // Currently, no specific actions are needed when the controller is closed
    }

    @FXML
    private Button FAF;

    // FXML fields for UI elements
    @FXML
    private Button FACTBackbt;

    @FXML
    private TextField FACTIDSearch;

    @FXML
    private TextField FACTNameSearch;

    @FXML
    private Button FACTSIDbt;

    @FXML
    private Button NameSbt;

    // Method to handle the Back button action
    @FXML
    void Backbt(ActionEvent event) throws IOException {
        // Change the scene to the SUChoose scene
        App.currentController.changeScene(Scenes.SUCHOOSE, null);
    }

    // Method to handle the Search by ID button action
    @FXML
    void SearchIDbt(ActionEvent event) throws IOException {
        // Find the faction by ID from the text field input
        fact = Dfact.findById(Integer.parseInt(FACTIDSearch.getText()));
        // Change the scene to the Faction scene, passing the found faction
        App.currentController.changeScene(Scenes.FACTION, fact);
    }

    // Method to handle the Search by Name button action
    @FXML
    void SearchNamebt(ActionEvent event) throws IOException {
        // Find the faction by name from the text field input
        fact = Dfact.findByName(FACTNameSearch.getText());
        // Change the scene to the Faction scene, passing the found faction
        App.currentController.changeScene(Scenes.FACTION, fact);
    }

    @FXML
    void FindAF(ActionEvent event) throws IOException {
        App.currentController.changeScene(Scenes.TFACT, null);
    }
}

