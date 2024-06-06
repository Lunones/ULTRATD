package org.example.view;

import javafx.beans.Observable;
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
import org.example.model.dao.SkillDAO;
import org.example.model.entity.Faction;
import org.example.model.entity.Skill;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TableSkillController extends Controller implements Initializable {



    private ObservableList<Skill> skills = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableViewSkill.setEditable(true);
        IdS.setCellValueFactory(Skill-> {
            int id = Skill.getValue().getId();
            return new SimpleIntegerProperty(id).asObject();
        });
        DescS.setCellValueFactory(Skill-> new SimpleStringProperty(Skill.getValue().getDescription()));
    }

    @Override
    public void onOpen(Object input) throws IOException {
        List<Skill> skills = SkillDAO.build().findAllTable();
        this.skills = FXCollections.observableArrayList(skills);
        TableViewSkill.setItems(this.skills);
    }

    @Override
    public void onClose(Object output) {

    }
    @FXML
    private TableView<Skill> TableViewSkill;

    @FXML
    private TableColumn <Skill, Integer> IdS;

    @FXML
    private TableColumn <Skill, String> DescS;

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
    void Backbt(ActionEvent event) throws IOException {
        App.currentController.changeScene(Scenes.SUCHOOSE, null);
    }

    @FXML
    void Delete(ActionEvent event) {

    }

    @FXML
    void Modify(ActionEvent event) {

    }

    @FXML
    void New(ActionEvent event) {

    }

    @FXML
    void Save(ActionEvent event) {

    }

}
