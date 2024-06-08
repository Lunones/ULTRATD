package org.example.view;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.App;
import org.example.model.dao.FactionDAO;
import org.example.model.dao.UserDAO;
import org.example.model.entity.Faction;
import org.example.model.entity.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class UserController extends Controller implements Initializable {

    // Instance variables
    private User us = new User();               // User object to hold user details
    private UserDAO udao = new UserDAO();       // Data Access Object for User
    private List<String> Fact = FactionDAO.build().findAll();  // List to hold all faction names
    private Faction newf = new Faction();
    private int idFact;                         // Variable to hold the ID of the selected faction

    @Override
    public void onOpen(Object input) throws IOException {
        // Method called when the view is opened
        us = (User) input;  // Cast input to User
        ListFaction.getItems().addAll(Fact);  // Add all faction names to the ComboBox
        txtID.setEditable(false);

        if (us == null) {
            // If no user is passed (creating a new user)
            Modify.setVisible(false);  // Hide Modify button
            Delete.setVisible(false);  // Hide Delete button
            txtfaction.setVisible(false);
            txtID.setVisible(false);
            lblid.setVisible(false);
            txtLVL.setText(1+"");
        } else {
            String namefact = us.getFaction().getName();
            txtID.setEditable(false);
            txtfaction.setEditable(false);
            txtID.setText(us.getId()+"");
            txtLVL.setText(us.getLvl()+"");
            txtpass.setText(us.getPassword());
            txtuser.setText(us.getName());
            Save.setVisible(false);
            ListFaction.setVisible(false);
            txtfaction.setText(namefact);// Hide Save button
        }
    }

    // Method to clear the input fields
    private void New() {
        txtID.setText("");
        txtLVL.setText("");
        txtpass.setText("");
        txtuser.setText("");
    }

    // FXML injected elements
    @FXML
    private Button Delete;
    @FXML
    private ComboBox<String> ListFaction;
    @FXML
    private Button Modify;
    @FXML
    private Button Save;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtLVL;
    @FXML
    private TextField txtpass;
    @FXML
    private TextField txtuser;
    @FXML
    private TextField txtfaction;

    @FXML
    private Label lblid;

    @FXML
    private Label lbllvl;

    // Event handler for Back button
    @FXML
    void Backbt(ActionEvent event) throws IOException {
            App.currentController.changeScene(Scenes.SUCHOOSE, null);
    }

    // Event handler for Delete button
    @FXML
    void Deletebt(ActionEvent event) throws SQLException {
        // Create a new User object from the input fields
        us = new User(Integer.parseInt(txtID.getText()), txtuser.getText(), txtpass.getText(),
                Integer.parseInt(txtLVL.getText()));
        udao.delete(us);  // Delete the user from the database
        New();  // Clear input fields
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("The user has been deleted successfully");
        alert.show();  // Show confirmation alert
    }

    // Event handler for Modify button
    @FXML
    void Modifybt(ActionEvent event) throws SQLException {
        // Create a new User object from the input fields
        us = new User(Integer.parseInt(txtID.getText()), txtuser.getText(), txtpass.getText(),
                Integer.parseInt(txtLVL.getText()));
        // Placeholder for update operation (currently commented out)
        udao.update(us);
        New();  // Clear input fields
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("The user has been modified successfully");
        alert.show();  // Show confirmation alert
    }

    // Event handler for Save button
    @FXML
    void Savebt(ActionEvent event) {
        String selectedFaction = String.valueOf(ListFaction.getSelectionModel().getSelectedItem());
        newf = FactionDAO.build().findByName(selectedFaction);
        // Create a new User object from the input fields
        us = new User(txtuser.getText(), txtpass.getText(),
                Integer.parseInt(txtLVL.getText()), newf);
        udao.save(us);  // Save the user to the database
        New();  // Clear input fields
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("The user has been saved successfully");
        alert.show();  // Show confirmation alert
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Method called to initialize the controller after its root element has been completely processed
    }

    // Event handler for selecting a faction from the ComboBox
    @FXML
    void idfactCombobox(ActionEvent event) {
        String selectedFaction = String.valueOf(ListFaction.getSelectionModel().getSelectedItem());  // Get selected faction name
        Faction byName = FactionDAO.build().findByName(selectedFaction);  // Find faction by name
        idFact = byName.getId();  // Set idFact to the ID of the selected faction
    }

    @Override
    public void onClose(Object output) {
        // Method called when the view is closed
    }
}