package edu.hanover.schedulevisualizer.ui;

import edu.hanover.schedulevisualizer.core.Context;
import edu.hanover.schedulevisualizer.ui.elements.TimeSlotGrid;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TimeSlotGrid grid;

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
        grid.displayData(context.getData());
    }

}