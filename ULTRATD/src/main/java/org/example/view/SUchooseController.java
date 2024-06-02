package org.example.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import org.example.App;
import org.example.model.entity.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static org.example.view.AppController.loadFXML;
import static org.example.view.Scenes.*;

public class SUchooseController extends Controller implements Initializable {
    // Instance variable to hold a User object
    private User usersu = new User();

    // Method called when the controller is initialized
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialization code can be added here
    }

    // Method called when the view associated with this controller is opened
    @Override
    public void onOpen(Object input) throws IOException {
        usersu = (User) input;
    }
    // Method called when the view associated with this controller is closed
    @Override
    public void onClose(Object output) {
        // Any cleanup code can be added here
    }

    // FXML element declarations
    @FXML
    private BorderPane SUBorderpane;
    @FXML
    void AUTDbt(ActionEvent event) {

    }


    // Event handler for navigating to the Faction creation page
    @FXML
    void Fnewbt(ActionEvent event) throws IOException {
        App.currentController.changeScene(FACTION, null);
    }
    // Event handler for navigating to the Faction search page
    @FXML
    void Fsearchbt(ActionEvent event) throws IOException {
        App.currentController.changeScene(SFACTION, null);
    }
    // Event handler for navigating to the Skill creation page
    @FXML
    void Snewbt(ActionEvent event) throws IOException{
        App.currentController.changeScene(SKILL, null);
    }
    // Event handler for navigating to the Skill search page
    @FXML
    void Ssearchbt(ActionEvent event) throws IOException{
        App.currentController.changeScene(SSKILL, null);
    }

    // Event handler for navigating to the Unit creation page
    @FXML
    void Uninewbt(ActionEvent event) throws IOException{
        App.currentController.changeScene(UNIT, null);
    }
    // Event handler for navigating to the Unit search page
    @FXML
    void Unisearchbt(ActionEvent event) throws IOException{
        App.currentController.changeScene(SUNIT, null);
    }
    // Event handler for navigating to the User creation page
    @FXML
    void Usenewbt(ActionEvent event) throws IOException{
        App.currentController.changeScene(USER, usersu);
    }

    @FXML
    void Usesearchbt(ActionEvent event) throws IOException{
        App.currentController.changeScene(SUSER, usersu);
    }

    @FXML
    void Quitbt(ActionEvent event) {
        System.exit(0);
    }
}
