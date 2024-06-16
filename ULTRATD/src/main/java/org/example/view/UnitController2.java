package org.example.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.example.App;
import org.example.model.dao.SkillDAO;
import org.example.model.dao.UnitDAO;
import org.example.model.dao.UserDAO;
import org.example.model.entity.Skill;
import org.example.model.entity.Unit;
import org.example.model.entity.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
public class UnitController2 extends Controller implements Initializable {
        // Instance variables
        private Unit un = new Unit();
        private UnitDAO undao = new UnitDAO();
        private List<String> use = UserDAO.build().findAll();  // List to hold all faction names
        private List<String> ski = SkillDAO.build().findAll();  // List to hold all skill names
        private Skill news = new Skill();
        private User newu = new User();

        private int idSkill;
        private int idUser;

        // Initialization method
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

                txtIDu.setEditable(false);
                txtdesc.setEditable(false);
                txtatk.setEditable(false);
                txthp.setEditable(false);
                txttype.setEditable(false);
                txtskill.setEditable(false);
                txtuser.setEditable(false);
        }

        // Method called when the view is opened
        @Override
        public void onOpen(Object input) throws IOException {
                // Cast input to Unit
                un = (Unit) input;
                        txtIDu.setText(un.getId() + "");
                        txtdesc.setText(un.getDescription());
                        txtatk.setText(un.getAtk() + "");
                        txthp.setText(un.getHp() + "");
                        txttype.setText(un.getType());
                        txtskill.setText(un.getSkill().getDescription());
                        txtuser.setText(un.getUser().getName());

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

        // Event handler for back button
        @FXML
        void Backbt(ActionEvent event) throws IOException {
            // Navigate back to the previous scene
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
}
