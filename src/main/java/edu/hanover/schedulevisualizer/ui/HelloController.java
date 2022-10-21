package edu.hanover.schedulevisualizer.ui;

import edu.hanover.schedulevisualizer.core.Context;
import edu.hanover.schedulevisualizer.core.Course;
import edu.hanover.schedulevisualizer.core.Weekday;
import edu.hanover.schedulevisualizer.ui.elements.CourseEntry;
import edu.hanover.schedulevisualizer.ui.elements.DayColumn;
import edu.hanover.schedulevisualizer.ui.elements.TimeSlot;
import edu.hanover.schedulevisualizer.ui.elements.TimeSlotGrid;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.List;

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
        context.getData().forEach(this::displayCourse);
    }

    private void displayCourse(Course course) {
        for (Weekday weekday : course.getTimeSlot().getWeekdayList()) {
            CourseEntry entry = new CourseEntry();
            entry.setText(course.getCourseCode());
            entry.setColor(Color.AQUA);
            TimeSlot timeSlot = getUITimeSlot(course.getTimeSlot().slotnum, weekday);
            timeSlot.addEntry(entry);
        }

    }

    private TimeSlot getUITimeSlot(int slotnum, Weekday weekday) {
        return grid.getDayColumn(weekday).getTimeSlot(slotnum);
    }
}