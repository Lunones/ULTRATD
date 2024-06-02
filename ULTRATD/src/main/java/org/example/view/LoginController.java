package org.example.view;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.App;
import org.example.model.dao.UserDAO;
import org.example.model.entity.User;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static org.example.view.AppController.loadFXML;

public class LoginController extends Controller implements Initializable {
    public ErrorController controller;
    public SUchooseController controller1;

    private final AppController appc = new AppController();
    private User us = new User();
    //public Controller AppController;
    @FXML
    private Button btstart;

    @FXML
    private TextField txtname;

    @FXML
    private PasswordField txtpass;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialization code can be added here if needed
    }

    @Override
    public void onOpen(Object input) throws IOException {
        // Any actions to be performed when the controller is opened can be added here
    }

    @Override
    public void onClose(Object output) {
        // Any actions to be performed when the controller is closed can be added here
    }

    @FXML
    void Newbt(ActionEvent event) {
        try {
            App.currentController.changeScene(Scenes.NUSER, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Startbt(ActionEvent event) throws IOException {
        us = UserDAO.build().findByname(txtname.getText());
        if(us == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("User or password are incorrect");
            alert.show();
        }
        else if(us.getName().equals(txtname.getText()) && us.getPassword().equals(txtpass.getText()) &&
                us.getLvl() < 99){
            App.currentController.changeScene(Scenes.UTD, null);

        } else if (us.getName().equals(txtname.getText()) && us.getPassword().equals(txtpass.getText()) &&
                us.getLvl() == 99) {
            App.currentController.changeScene(Scenes.SUCHOOSE, us);
        }
    }
}

