package edu.hanover.schedulevisualizer.ui.elements;

import edu.hanover.schedulevisualizer.core.Weekday;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

import static edu.hanover.schedulevisualizer.core.Weekday.Thursday;
import static edu.hanover.schedulevisualizer.core.Weekday.Tuesday;


public class DayColumn extends VBox {
    @FXML
    private Label label;
    private Weekday day;

    public DayColumn() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "dayColumn-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public Weekday getDay() {
        return day;
    }

    public void setDay(Weekday day) {
        this.day = day;
        label.setText(day.name());
        addSlots();
    }

    private void addSlots() {
        boolean isTR = day == Tuesday || day == Thursday;
        int numSlots = isTR ? 4 : 6;
        String dayPattern = isTR ? "TR" : "MWF";
        for (int i = 1; i <= numSlots; i++) {
            TimeSlot timeSlot = new TimeSlot();
            timeSlot.setDay(dayPattern);
            timeSlot.setId("slot" + i + getId());
            getChildren().add(timeSlot);
        }
    }

}
