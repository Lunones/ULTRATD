package org.example.view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.example.App;
import org.example.model.dao.UnitDAO;
import org.example.model.dao.UserDAO;
import org.example.model.entity.Faction;
import org.example.model.entity.Unit;
import org.example.model.entity.User;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TableUserController extends Controller implements Initializable {
    private ObservableList<User> users = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableViewUser.setEditable(true);
        IdUS.setCellValueFactory(User-> {
            int id = User.getValue().getId();
            return new SimpleIntegerProperty(id).asObject();
        });

        Name.setCellValueFactory(User-> new SimpleStringProperty(User.getValue().getName()));

        Password.setCellValueFactory(User-> new SimpleStringProperty(User.getValue().getPassword()));

        LVL.setCellValueFactory(User-> {
            int LVL = User.getValue().getLvl();
            return new SimpleIntegerProperty(LVL).asObject();
        });

        Id_faction.setCellValueFactory(User->
                new SimpleStringProperty(User.getValue().getFaction().getName()));
    }

    @Override
    public void onOpen(Object input) throws IOException {
        List<User> users = UserDAO.build().findAllTable();
        //System.out.println(factions);
        this.users = FXCollections.observableArrayList(users);
        TableViewUser.setItems(this.users);
    }

    @Override
    public void onClose(Object output) {

    }
    @FXML
    private Button Delete;

    @FXML
    private TableColumn<User, Integer> IdUS;

    @FXML
    private TableColumn<User, String> Id_faction;

    @FXML
    private TableColumn<User, Integer> LVL;

    @FXML
    private Button Modify;

    @FXML
    private TableColumn<User, String> Name;

    @FXML
    private TableColumn<User, String> Password;

    @FXML
    private Button Save;

    @FXML
    private TableView<User> TableViewUser;

    @FXML
    void Backbt(ActionEvent event) throws IOException {
        App.currentController.changeScene(Scenes.SUCHOOSE, null);
    }

    @FXML
    void Deletebt(ActionEvent event) {

    }

    @FXML
    void Modifybt(ActionEvent event) {

    }

    @FXML
    void Savebt(ActionEvent event) {

    }

}
