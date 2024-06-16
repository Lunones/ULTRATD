package org.example.view;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

// AppController class without imports
public class AppController extends Controller implements Initializable {
    @FXML
    private BorderPane borderPane;
    public Controller centerController;

    @Override
    public void onOpen(Object input) throws IOException {
        // Al abrir este controlador que cargue main en el centro
        changeScene(Scenes.LOGIN, null);
    }

    public void changeScene(Scenes scene, Object data) throws IOException {
        View view = loadFXML(scene);
        borderPane.setCenter(view.scene);
        this.centerController = view.controller;
        this.centerController.onOpen(data);
    }

    public void openModal(Scenes scenes, String s, Controller parent, Object o) throws IOException {
        View view = loadFXML(scenes);
        Stage stage = new Stage();
        stage.setTitle(s);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(App.stage);
        Scene _scene = new Scene(view.scene);
        stage.setScene(_scene);
        view.controller.onOpen(o);
        stage.showAndWait();
    }

    @Override
    public void onClose(Object output) {
        // nothing to do
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public static View loadFXML(Scenes scenes) throws IOException {
        String url = scenes.getURL();
        System.out.println(url);
        FXMLLoader loader = new FXMLLoader(App.class.getResource(url));
        Parent p = loader.load();
        Controller c = loader.getController();
        View view = new View();
        view.scene = p;
        view.controller = c;
        return view;
    }
}


