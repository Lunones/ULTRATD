package org.example.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.App;
import org.example.model.dao.SkillDAO;
import org.example.model.dao.UserDAO;
import org.example.model.entity.Skill;
import org.example.model.entity.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static org.example.view.Scenes.SUCHOOSE;

public class SearchUserController extends Controller implements Initializable {

    // Instance variables
    private User use = new User();
    private UserDAO Duse = new UserDAO();

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
    private Button NameSbt;
    @FXML
    private Button USBackbt;
    @FXML
    private TextField USIDSearch;
    @FXML
    private TextField USNameSearch;
    @FXML
    private Button USSIDbt;

    // Event handler for back button
    @FXML
    void Backbt(ActionEvent event) throws IOException {
        // Navigate back to the previous scene
        App.currentController.changeScene(SUCHOOSE, null);
    }

    // Event handler for searching by ID button
    @FXML
    void SearchIDbt(ActionEvent event) throws IOException {
        // Find the user by ID from the text field input
        use = Duse.findById(Integer.parseInt(USIDSearch.getText()));
        // Change the scene to the User scene, passing the found user
        App.currentController.changeScene(Scenes.USER, use);
    }

    // Event handler for searching by name button
    @FXML
    void SearchNamebt(ActionEvent event) throws IOException {
        // Find the user by name from the text field input
        use = Duse.findByname(USNameSearch.getText());
        // Change the scene to the User scene, passing the found user
        App.currentController.changeScene(Scenes.USER, use);
    }
}

