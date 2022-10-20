package edu.hanover.schedulevisualizer.ui.elements;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

import static edu.hanover.schedulevisualizer.ui.elements.DayPattern.MWF;


public class TimeSlot extends VBox {

    private DayPattern dayPattern;

    public TimeSlot() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "timeslot-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    static TimeSlot forDayPattern(DayPattern dayPattern, String slotID) {
        TimeSlot timeSlot = new TimeSlot();
        timeSlot.setDayPattern(dayPattern);
        timeSlot.setId(slotID);
        return timeSlot;
    }

    public DayPattern getDayPattern() {
        return dayPattern;
    }

    public void setDayPattern(DayPattern dayPattern) {
        this.dayPattern = dayPattern;
        setPrefHeight(dayPattern == MWF ? 100 : 150);
    }

    public void addEntry(CourseEntry entry) {
        getChildren().add(entry);
    }
}
