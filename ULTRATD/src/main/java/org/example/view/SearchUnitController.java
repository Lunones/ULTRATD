package org.example.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.App;
import org.example.model.dao.UnitDAO;
import org.example.model.dao.UserDAO;
import org.example.model.entity.Unit;
import org.example.model.entity.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static org.example.view.Scenes.SUCHOOSE;

public class SearchUnitController extends Controller implements Initializable {
    // Instance variables
    private Unit uni = new Unit();
    private UnitDAO Duni = new UnitDAO();

    // Method called when the controller is initialized
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialization code can be added here
    }

    // Method called when the view is opened
    @Override
    public void onOpen(Object input) throws IOException {
        // Any necessary setup code can be added here
    }

    // Method called when the view is closed
    @Override
    public void onClose(Object output) {
        // Any cleanup code can be added here
    }

    // FXML element declarations
    @FXML
    private Button UNBackbt;
    @FXML
    private TextField UNIDSearch;
    @FXML
    private Button UNNameSbt;
    @FXML
    private TextField UNNameSearch;
    @FXML
    private Button UNSIDbt;

    // Event handler for back button
    @FXML
    void Backbt(ActionEvent event) throws IOException {
        // Navigate back to the previous scene
        App.currentController.changeScene(SUCHOOSE, null);
    }

    // Event handler for searching by ID button
    @FXML
    void SearchIDbt(ActionEvent event) throws IOException {
        // Find the unit by ID from the text field input
        uni = Duni.findById(Integer.parseInt(UNIDSearch.getText()));
        // Change the scene to the Unit scene, passing the found unit
        App.currentController.changeScene(Scenes.UNIT, uni);
    }

    // Event handler for searching by name button
    @FXML
    void SearchNamebt(ActionEvent event) throws IOException {
        // Find the unit by name from the text field input
        uni = Duni.findByname(UNNameSearch.getText());
        // Change the scene to the Unit scene, passing the found unit
        App.currentController.changeScene(Scenes.UNIT, uni);
    }
}

