package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.view.*;

import java.io.IOException;

// This class represents the main entry point of your JavaFX application
public class App extends Application {

    // Default constructor
    public App() {

    }

    // Static variables to manage scene, stage, and controller
    private static Scene scene;
    public static Stage stage;
    public static AppController currentController;

    // Override the start method provided by Application
    @Override
    public void start(Stage stage) throws IOException {
        // Load the root FXML file
        View view = AppController.loadFXML(Scenes.ROOT);
        // Create a scene with a specified size
        scene = new Scene(view.scene, 640, 480);
        // Initialize the controller and perform any necessary setup
        currentController = (AppController) view.controller;
        currentController.onOpen(null);
        // Set the scene to the stage and display the stage
        stage.setScene(scene);
        stage.show();
    }

    // Static method to change the root FXML file displayed in the scene
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    // Private method to load FXML files using FXMLLoader
    private static <Parent> Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    // Main method to launch the application
    public static void main(String[] args) {
        launch();
    }

}
