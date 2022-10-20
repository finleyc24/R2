package edu.hanover.schedulevisualizer.ui;

import edu.hanover.schedulevisualizer.core.Context;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    Context context;

    public HelloController() {
        this.context = Context.getInstance();
    }
    @FXML
    void initialize(){
        System.out.println("something");
    }
}