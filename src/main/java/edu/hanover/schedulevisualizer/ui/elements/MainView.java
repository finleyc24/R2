package edu.hanover.schedulevisualizer.ui.elements;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class MainView extends HBox {
    public MainView() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "main-view.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
