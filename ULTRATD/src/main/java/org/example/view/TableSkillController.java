package org.example.view;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.example.model.dao.SkillDAO;
import org.example.model.entity.Skill;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TableSkillController extends Controller implements Initializable {

    @FXML
    private TableView<Skill> TableViewSkill;

    @FXML
    private TableColumn<Skill, Integer> IdS;
    @FXML
    private TableColumn<Skill, String> DescS;

    private ObservableList<Skill> skills;

    @Override
    public void onOpen(Object input) throws IOException {
        List<String> skills = SkillDAO.build().findAll();
        System.out.println(skills);
        this.skills = FXCollections.observableArrayList();
        TableViewSkill.setItems(this.skills);
    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableViewSkill.setEditable(true);
    }


}
