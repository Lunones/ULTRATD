package org.example.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.App;
import org.example.model.dao.FactionDAO;
import org.example.model.dao.SkillDAO;
import org.example.model.entity.Faction;
import org.example.model.entity.Skill;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class SkillController extends Controller implements Initializable {
    // Instance variables
    private Skill skill = new Skill();
    private SkillDAO skillDAO = new SkillDAO();

    // Method to reset text fields
    private void resetFields() {
        txtIDs.setText("");
        txtdescS.setText("");
    }

    // Method called when the view is opened
    @Override
    public void onOpen(Object input) throws IOException {
        // Assign the received skill to the local variable 'skill'
        this.skill = (Skill) input;
        // Set the ID text field as non-editable
        txtIDs.setEditable(false);
        if (skill == null) {
            // If no skill is received, hide the delete and modify buttons
            DeletebtS.setVisible(false);
            ModifybtS.setVisible(false);
        } else {
            // If a skill is received, fill the text fields with the skill data
            txtIDs.setText(String.valueOf(skill.getId()));
            txtdescS.setText(skill.getDescription());
            // Hide the save and new buttons
            SavebtS.setVisible(false);
            NewbtS.setVisible(false);
        }
    }

    // Method called when the controller is initialized
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialization code can be added here
    }

    // FXML element declarations
    @FXML
    private Button Backbt;
    @FXML
    private Button DeletebtS;
    @FXML
    private Button ModifybtS;
    @FXML
    private Button NewbtS;
    @FXML
    private Button SavebtS;
    @FXML
    private TextField txtIDs;
    @FXML
    private TextField txtdescS;

    // Event handler for delete button
    @FXML
    void Delete(ActionEvent event) {
        try {
            // Create a new instance of Skill with the form data
            skill = new Skill(Integer.parseInt(txtIDs.getText()), txtdescS.getText());
            // Call the delete method of the DAO to remove the skill from the database
            skillDAO.delete(skill);
            // Reset the form fields
            resetFields();
            // Show a confirmation alert
            showAlert(Alert.AlertType.CONFIRMATION, "The skill has been deleted successfully");
        } catch (NumberFormatException e) {
            // Show an error alert if the ID format is invalid
            showAlert(Alert.AlertType.ERROR, "Invalid ID format");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to show an alert
    private void showAlert(Alert.AlertType alertType, String s) {
        Alert alert = new Alert(alertType);
        alert.setContentText(s);
        alert.show();
    }

    // Event handler for modify button
    @FXML
    void Modify(ActionEvent event) {
        try {
            // Create a new instance of Skill with the form data
            skill = new Skill(Integer.parseInt(txtIDs.getText()), txtdescS.getText());
            // Call the update method of the DAO to update the skill in the database
            skillDAO.update(skill);
            // Show a confirmation alert
            showAlert(Alert.AlertType.CONFIRMATION, "The skill has been modified successfully");
        } catch (NumberFormatException e) {
            // Show an error alert if the ID format is invalid
            showAlert(Alert.AlertType.ERROR, "Invalid ID format");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Event handler for new button
    @FXML
    void New(ActionEvent event) {
        // Reset form fields
        resetFields();
    }

    // Event handler for save button
    @FXML
    void Save(ActionEvent event) {
        try {
            // Create a new instance of Skill with the form data
            skill = new Skill(txtdescS.getText());
            // Call the save method of the DAO to save the skill in the database
            skillDAO.save(skill);
            // Reset the form fields
            resetFields();
            // Show a confirmation alert
            showAlert(Alert.AlertType.CONFIRMATION, "The Skill has been saved successfully");
        } catch (NumberFormatException e) {
            // Show an error alert if the ID format is invalid
            showAlert(Alert.AlertType.ERROR, "Invalid ID format");
        }
    }

    // Method called when the view is closed
    @Override
    public void onClose(Object output) {
        // Any cleanup code can be added here
    }

    // Event handler for back button
    @FXML
    void Backbt(ActionEvent event) throws IOException {
        // Navigate back to the previous scene
        App.currentController.changeScene(Scenes.SUCHOOSE, null);
    }
}

