package edu.hanover.schedulevisualizer.ui.elements;

import edu.hanover.schedulevisualizer.core.Weekday;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class TimeSlotGrid extends HBox {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public TimeSlotGrid() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "timeslotgrid-view.fxml"));
        fxmlLoader.setRoot(this);
        addDayColumns();
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private void addDayColumns() {
        for (Weekday weekday : Weekday.values()) {
            getChildren().add(DayColumn.forWeekday(weekday));
        }
    }
}
