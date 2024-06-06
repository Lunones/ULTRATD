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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.example.App;
import org.example.model.dao.FactionDAO;
import org.example.model.entity.Faction;
import org.example.model.entity.Skill;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TableFactionController extends Controller implements Initializable {

    private ObservableList<Faction> factions = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableViewFaction.setEditable(true);
        IdF.setCellValueFactory(Faction-> {
            int id = Faction.getValue().getId();
            return new SimpleIntegerProperty(id).asObject();
        });
        DescF.setCellValueFactory(Faction-> new SimpleStringProperty(Faction.getValue().getName()));
    }

    @Override
    public void onOpen(Object input) throws IOException {
        List<Faction> factions = FactionDAO.build().findAllTable();
        //System.out.println(factions);
        this.factions = FXCollections.observableArrayList(factions);
        TableViewFaction.setItems(this.factions);
    }

    @Override
    public void onClose(Object output) {

    }
    @FXML
    private TableView<Faction> TableViewFaction;
    @FXML
    private TableColumn<Faction, String> DescF;
    @FXML
    private TableColumn<Faction, Integer> IdF;
    @FXML
    private Button Deletebt;

    @FXML
    private Button Modifybt;

    @FXML
    private Button NFBackbt;

    @FXML
    private Button Newbt;

    @FXML
    private Button Savebt;
    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtId;

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
    /*@FXML
    private void sel(MouseEvent event) {
        Faction f= this.TableViewFaction.getSelectionModel().getSelectedItem();
        if (f != null){
            this.txtId.setText(f.getId()+"");
            this.txtDescription.setText(f.getName());

        }
    }*/

}
