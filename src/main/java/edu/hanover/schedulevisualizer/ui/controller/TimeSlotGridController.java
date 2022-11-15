package edu.hanover.schedulevisualizer.ui.controller;

import edu.hanover.schedulevisualizer.core.Context;
import edu.hanover.schedulevisualizer.ui.elements.TimeSlotGrid;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TimeSlotGridController {
    @FXML
    private Label welcomeText;

    @FXML
    private TimeSlotGrid grid;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    Context context;

    public TimeSlotGridController() {
        this.context = Context.getInstance();
    }
    @FXML
    void initialize(){
        context.addObserver(grid);
    }

}