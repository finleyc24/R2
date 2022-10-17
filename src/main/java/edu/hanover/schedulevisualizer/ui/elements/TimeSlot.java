package edu.hanover.schedulevisualizer.ui.elements;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;


public class TimeSlot extends VBox {

    private String day;

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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
        setPrefHeight(day.equals("MWF") ? 100 : 150);
    }

}
