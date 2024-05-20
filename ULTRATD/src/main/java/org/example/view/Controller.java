package org.example.view;

import java.io.IOException;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.App;

import static org.example.view.AppController.loadFXML;

public abstract class Controller {
    App app;

    public void setApp(App app) {
        this.app = app;
    }

    // Abstract method to be implemented by subclasses to handle opening the controller
    public abstract void onOpen(Object input) throws IOException;

    // Abstract method to be implemented by subclasses to handle closing the controller
    public abstract void onClose(Object output);
}


