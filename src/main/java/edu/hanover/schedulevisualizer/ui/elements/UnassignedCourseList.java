package edu.hanover.schedulevisualizer.ui.elements;

import edu.hanover.schedulevisualizer.core.Course;
import edu.hanover.schedulevisualizer.observable.MyObserver;
import javafx.application.Platform;
import javafx.scene.layout.VBox;

import java.util.List;

public class UnassignedCourseList extends VBox implements MyObserver<List<Course>> {

    void addCourse(Course course){
        getChildren().add(CourseEntry.forCourse(course));
    }

    public void update(List<Course> courses) {
        Platform.runLater(() -> displayData(courses));
    }

    private void displayData(List<Course> courses) {
        courses.forEach(this::displayCourse);
    }

    private void displayCourse(Course course) {
        course.getTimeslot().ifUnassignedSlotDo(()-> addCourse(course));
    }
}
