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
import java.util.List;
import java.util.ResourceBundle;

public class NewUserController extends Controller implements Initializable {
    private User us;               // User object to hold user details
    private UserDAO udao;       // Data Access Object for User
    private List<String> fact;  // List to hold all faction names
    private Faction newf = new Faction();
    private int idFact;                         // Variable to hold the ID of the selected faction

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        us = new User();
        udao = new UserDAO();
        fact = FactionDAO.build().findAll();
    }

    @Override
    public void onOpen(Object input) throws IOException {
        us = (User) input;  // Cast input to User
        ListFaction.getItems().addAll(fact);  // Add all faction names to the ComboBox
        txtID.setEditable(false);
        txtID.setVisible(false);
        txtLVL.setVisible(false);
        lblid.setVisible(false);
        lbllvl.setVisible(false);
        txtLVL.setText(1+"");
    }

    @Override
    public void onClose(Object output) {

    }

    private void New() {
        txtID.setText("");
        txtLVL.setText("");
        txtpass.setText("");
        txtuser.setText("");
    }

    @FXML
    private ComboBox<String> ListFaction;

    @FXML
    private Button Savebt;

    @FXML
    private Label lblid;

    @FXML
    private Label lbllvl;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtLVL;

    @FXML
    private TextField txtpass;

    @FXML
    private TextField txtuser;

    @FXML
    void Backbt(ActionEvent event) throws IOException{
        App.currentController.changeScene(Scenes.LOGIN, null);
    }

    @FXML
    void Savebt(ActionEvent event) {
        // Create a new User object from the input fields
        String selectedFaction = String.valueOf(ListFaction.getSelectionModel().getSelectedItem());
        newf = FactionDAO.build().findByName(selectedFaction);
        us = new User(txtuser.getText(), txtpass.getText(),
                Integer.parseInt(txtLVL.getText()), newf);
        udao.save(us);  // Save the user to the database
        New();  // Clear input fields
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("The user has been saved successfully");
        alert.show();  // Show confirmation alert
    }

    @FXML
    void idfactCombobox(ActionEvent event) {
        String selectedFaction = String.valueOf(ListFaction.getSelectionModel().getSelectedItem());  // Get selected faction name
        Faction byName = FactionDAO.build().findByName(selectedFaction);  // Find faction by name
        idFact = byName.getId();  // Set idFact to the ID of the selected faction
    }

}
