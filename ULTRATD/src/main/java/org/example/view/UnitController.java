package org.example.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.example.App;
import org.example.model.dao.FactionDAO;
import org.example.model.dao.SkillDAO;
import org.example.model.dao.UnitDAO;
import org.example.model.dao.UserDAO;
import org.example.model.entity.Faction;
import org.example.model.entity.Skill;
import org.example.model.entity.Unit;
import org.example.model.entity.User;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class UnitController extends Controller implements Initializable {
    // Instance variables
    private Unit un = new Unit();
    private UnitDAO undao = new UnitDAO();
    private List<String> use = UserDAO.build().findAll();  // List to hold all faction names
    private List<String> ski = SkillDAO.build().findAll();  // List to hold all skill names
    private int idSkill;
    private int idUser;

    // Initialization method
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialization code can be added here
    }

    // Method called when the view is opened
    @Override
    public void onOpen(Object input) throws IOException {
        // Cast input to Unit
        un = (Unit) input;
        // Add all faction names to the ComboBox
        ListUser.getItems().addAll(use);
        // Add all skill names to the ComboBox
        ListSkills.getItems().addAll(ski);
        txtIDu.setEditable(false);
        if (un == null) {
            // If no unit is passed (creating a new unit)
            ModifyUn.setVisible(false);  // Hide Modify button
            DeleteUn.setVisible(false);  // Hide Delete button
            txtuser.setVisible(false);
            txtskill.setVisible(false);
        } else {
            // If unit exists (editing existing unit)
            String nameus = un.getUser().getName();
            String nameski = un.getSkill().getDescription();
            txtIDu.setEditable(false);
            txtuser.setEditable(false);
            txtskill.setEditable(false);
            txtIDu.setText(un.getId()+"");
            txtdesc.setText(un.getDescription());
            txtatk.setText(un.getAtk()+"");
            txthp.setText(un.getHp()+"");
            txttype.setText(un.getType());
            SaveUn.setVisible(false);  // Hide Save button
            NewUn.setVisible(false);  // Hide New button
            ListUser.setVisible(false);  // Hide User ComboBox
            txtuser.setText(nameus);
            ListSkills.setVisible(false);  // Hide Skill ComboBox
            txtskill.setText(nameski);
        }
    }

    // Method to clear input fields
    private void New() {
        txtIDu.setText("");
        txtdesc.setText("");
        txtatk.setText("");
        txthp.setText("");
        txttype.setText("");
    }

    // Method called when the view is closed
    @Override
    public void onClose(Object output) {
        // Cleanup code can be added here
    }

    // FXML elements
    @FXML
    private Button Backbt;
    @FXML
    private Button DeleteUn;
    @FXML
    private ComboBox<String> ListSkills;
    @FXML
    private ComboBox<String> ListUser;
    @FXML
    private Button ModifyUn;
    @FXML
    private Button NewUn;
    @FXML
    private Button SaveUn;
    @FXML
    private TextField txtIDu;
    @FXML
    private TextField txtatk;
    @FXML
    private TextField txtdesc;
    @FXML
    private TextField txthp;
    @FXML
    private TextField txtskill;
    @FXML
    private TextField txttype;
    @FXML
    private TextField txtuser;

    // Event handler for skill ComboBox
    @FXML
    void idskillCombobox(ActionEvent event) {
        // Get selected skill name
        String selectedSkill = String.valueOf(ListSkills.getSelectionModel().getSelectedItem());
        // Find skill by name
        Skill byName = SkillDAO.build().findByName(selectedSkill);
        // Set idSkill to the ID of the selected skill
        idSkill = byName.getId();
    }

    // Event handler for user ComboBox
    @FXML
    void iduserCombobox(ActionEvent event) {
        // Get selected user name
        String selectedUser = String.valueOf(ListUser.getSelectionModel().getSelectedItem());
        // Find user by name
        User byName = UserDAO.build().findByname(selectedUser);
        // Set idUser to the ID of the selected user
        idUser = byName.getId();
    }

    // Event handler for delete button
    @FXML
    void Deletebt(ActionEvent event) throws SQLException {
        // Create a new Unit object with ID obtained from input field
        un = new Unit(Integer.parseInt(txtIDu.getText()));
        // Delete the unit from the database
        undao.delete(un);
        // Clear input fields
        New();
        // Show confirmation alert
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("The unit has been deleted successfully");
        alert.show();
    }

    // Event handler for modify button
    @FXML
    void Modifybt(ActionEvent event) throws SQLException{
        // Create a new Unit object from input fields
        un = new Unit (Integer.parseInt(txtIDu.getText()), txtdesc.getText(), Integer.parseInt(txtatk.getText()),
                Integer.parseInt(txthp.getText()), txttype.getText());
        // Update the unit in the database
        undao.update(un);
        // Clear input fields
        New();
        // Show confirmation alert
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("The unit has been modified successfully");
        alert.show();
    }

    // Event handler for new button
    @FXML
    void Newbt(ActionEvent event) {
        // Clear input fields
        New();
    }

    // Event handler for save button
    @FXML
    void Savebt(ActionEvent event) {
        // Create a new Unit object from input fields
        un = new Unit (txtdesc.getText(), Integer.parseInt(txtatk.getText()),
                Integer.parseInt(txthp.getText()), txttype.getText(),
                idSkill, idUser);
        // Save the unit to the database
        undao.save(un);
        // Clear input fields
        New();
        // Show confirmation alert
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("The unit has been saved successfully");
        alert.show();
    }

    // Event handler for back button
    @FXML
    void Backbt(ActionEvent event) throws IOException{
        // Navigate back to the previous scene
        App.currentController.changeScene(Scenes.SUCHOOSE, null);
    }
}
