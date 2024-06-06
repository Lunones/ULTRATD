package org.example.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.App;
import org.example.model.dao.FactionDAO;
import org.example.model.dao.SkillDAO;
import org.example.model.entity.Faction;
import org.example.model.entity.Skill;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static org.example.view.Scenes.SUCHOOSE;
import static org.example.view.Scenes.TSKILL;

public class SearchSkillController extends Controller implements Initializable {
    // Instance variables
    private Skill sk = new Skill();
    private SkillDAO Dsk = new SkillDAO();

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
    private Button FAS;
    @FXML
    private Button SKBackbt;
    @FXML
    private TextField SKIDSearch;
    @FXML
    private Button SKNameSbt;
    @FXML
    private TextField SKNameSearch;
    @FXML
    private Button SKSIDbt;

    // Event handler for back button
    @FXML
    void Backbt(ActionEvent event) throws IOException {
        // Navigate back to the previous scene
        App.currentController.changeScene(SUCHOOSE, null);
    }

    // Event handler for searching by ID button
    @FXML
    void SearchIDbt(ActionEvent event) throws IOException {
        // Find the skill by ID from the text field input
        sk = Dsk.findById(Integer.parseInt(SKIDSearch.getText()));
        // Change the scene to the Skill scene, passing the found skill
        App.currentController.changeScene(Scenes.SKILL, sk);
    }

    // Event handler for searching by name button
    @FXML
    void SearchNamebt(ActionEvent event) throws IOException {
        // Find the skill by name from the text field input
        sk = Dsk.findByName(SKNameSearch.getText());
        // Change the scene to the Skill scene, passing the found skill
        App.currentController.changeScene(Scenes.SKILL, sk);
    }


    @FXML
    void FindAS(ActionEvent event) throws IOException {
        App.currentController.changeScene(Scenes.TSKILL, null);
    }
}
