package org.example.view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
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
import org.example.model.entity.Unit;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TableUnitController extends Controller implements Initializable {

    private ObservableList<Unit> units = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableViewUnit.setEditable(true);

        IdUN.setCellValueFactory(Unit-> {
            int id = Unit.getValue().getId();
            return new SimpleIntegerProperty(id).asObject();
        });

        DescUN.setCellValueFactory(Unit-> new SimpleStringProperty(Unit.getValue().getDescription()));

        ATK.setCellValueFactory(Unit-> {
            int ATK = Unit.getValue().getAtk();
            return new SimpleIntegerProperty(ATK).asObject();
        });

        HP.setCellValueFactory(Unit-> {
            int HP = Unit.getValue().getHp();
            return new SimpleIntegerProperty(HP).asObject();
        });

        Type.setCellValueFactory(Unit-> new SimpleStringProperty(Unit.getValue().getType()));

        Id_skill.setCellValueFactory(Unit-> {
            int Id_skill = Unit.getValue().getId_skill();
            return new SimpleIntegerProperty(Id_skill).asObject();
        });

        Id_user.setCellValueFactory(Unit-> {
            int Id_user = Unit.getValue().getId_skill();
            return new SimpleIntegerProperty(Id_user).asObject();
        });
    }

    @Override
    public void onOpen(Object input) throws IOException {
        List<Unit> units = UnitDAO.build().findAllTable();
        //System.out.println(factions);
        this.units = FXCollections.observableArrayList(units);
        TableViewUnit.setItems(this.units);
    }

    @Override
    public void onClose(Object output) {

    }

    @FXML
    private TableColumn<Unit, Integer> ATK;

    @FXML
    private Button Backbt;

    @FXML
    private Button DeleteUn;

    @FXML
    private TableColumn<Unit, String> DescUN;

    @FXML
    private TableColumn<Unit, Integer> HP;

    @FXML
    private TableColumn<Unit, Integer> IdUN;

    @FXML
    private TableColumn<Unit, Integer> Id_skill;

    @FXML
    private TableColumn<Unit, Integer> Id_user;

    @FXML
    private Button ModifyUn;

    @FXML
    private Button NewUn;

    @FXML
    private Button SaveUn;

    @FXML
    private TableView<Unit> TableViewUnit;

    @FXML
    private TableColumn<Unit, String> Type;

    @FXML
    void Backbt(ActionEvent event) throws IOException{
        App.currentController.changeScene(Scenes.SUCHOOSE, null);
    }

    @FXML
    void Deletebt(ActionEvent event) {

    }

    @FXML
    void Modifybt(ActionEvent event) {

    }

    @FXML
    void Newbt(ActionEvent event) {

    }

    @FXML
    void Savebt(ActionEvent event) {

    }
}
