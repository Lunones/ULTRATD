package org.example.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.example.App;
import org.example.model.dao.FactionDAO;
import org.example.model.entity.Faction;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class FactionController extends Controller implements Initializable {

    private Faction faction = new Faction();
    private FactionDAO factionDAO = new FactionDAO();

    @Override
    public void onOpen(Object input) throws IOException {
        // Assign the received faction to the local variable faction
        this.faction = (Faction) input;
        txtIDf.setEditable(false);

        if (faction == null) {
            // If no faction is received, hide the delete and modify buttons
            Deletebt.setVisible(false);
            Modifybt.setVisible(false);
        } else {
            // If a faction is received, fill the text fields with the faction data
            txtIDf.setText(String.valueOf(faction.getId()));
            txtnamef.setText(faction.getName());
            // Hide the save and new buttons
            Savebt.setVisible(false);
            Newbt.setVisible(false);
        }
    }

    private void resetFields() {
        txtIDf.setText("");
        txtnamef.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialization code can be added here if needed
    }

    @Override
    public void onClose(Object output) {
        // Add any cleanup logic here
    }

    @FXML
    private Button Deletebt, NFBackbt, Modifybt, Newbt, Savebt;

    @FXML
    private TextField txtIDf, txtnamef;

    @FXML
    void Backbt(ActionEvent event) throws IOException {
        // Change the scene to the corresponding view
        App.currentController.changeScene(Scenes.SUCHOOSE, null);
    }

    @FXML
    void Delete(ActionEvent event) throws SQLException {
        try {
            // Create a new instance of Faction with the form data
            faction = new Faction(Integer.parseInt(txtIDf.getText()), txtnamef.getText());
            // Call the delete method of the DAO to remove the faction from the database
            factionDAO.delete(faction);
            // Reset the form fields
            resetFields();
            // Show a confirmation alert
            showAlert(Alert.AlertType.CONFIRMATION, "The faction has been deleted successfully");
        } catch (NumberFormatException e) {
            // Show an error alert if the ID format is invalid
            showAlert(Alert.AlertType.ERROR, "Invalid ID format");
        }
    }

    @FXML
    void Modify(ActionEvent event) throws SQLException {
        try {
            // Create a new instance of Faction with the form data
            faction = new Faction(Integer.parseInt(txtIDf.getText()), txtnamef.getText());
            // Call the update method of the DAO to update the faction in the database
            factionDAO.update(faction);
            // Show a confirmation alert
            showAlert(Alert.AlertType.CONFIRMATION, "The faction has been modified successfully");
        } catch (NumberFormatException e) {
            // Show an error alert if the ID format is invalid
            showAlert(Alert.AlertType.ERROR, "Invalid ID format");
        }
    }

    @FXML
    void New(ActionEvent event) {
        // Reset the form fields
        resetFields();
    }

    @FXML
    void Save(ActionEvent event) {
        try {
            // Create a new instance of Faction with the form data
            faction = new Faction(txtnamef.getText());
            // Call the save method of the DAO to save the faction in the database
            factionDAO.save(faction);
            // Reset the form fields
            resetFields();
            // Show a confirmation alert
            showAlert(Alert.AlertType.CONFIRMATION, "The faction has been saved successfully");
        } catch (NumberFormatException e) {
            // Show an error alert if the ID format is invalid
            showAlert(Alert.AlertType.ERROR, "Invalid ID format");
        }
    }

    private void showAlert(Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.show();
    }
}

