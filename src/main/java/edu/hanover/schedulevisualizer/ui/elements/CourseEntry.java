package edu.hanover.schedulevisualizer.ui.elements;

import edu.hanover.schedulevisualizer.core.Course;
import edu.hanover.schedulevisualizer.ui.controller.DragAndDropController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class CourseEntry extends StackPane implements DragSource {
    @FXML
    Rectangle background;
    @FXML
    Label label;

    private Course course;

    private CourseEntry() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "course-entry-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
            DragAndDropController.getInstance().setupDragSource(this);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public String getDraggedContent() {
        return this.getText();
    }

    public void indicateDragEnded() {
        this.setColor(Color.AQUA);
    }

    public void indicateDragStarted() {
        this.setColor(Color.AZURE);
    }

    public CourseEntry getNode() {
        return this;
    }

    static CourseEntry forCourse(Course course) {
        CourseEntry entry = new CourseEntry();
        entry.setText(course.getCourseCode());
        entry.setColor(Color.AQUA);
        entry.course = course;
        return entry;
    }

    public String getText() {
        return label.getText();
    }

    public void setText(String text) {
        label.setText(text);
    }

    public Color getColor() {
        return (Color) background.getFill();
    }

    public void setColor(Color color) {
        background.setFill(color);
    }

    @FXML
    public void initialize() {
    }

    public Course getCourse() {
        return course;
    }
}
