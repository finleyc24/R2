package edu.hanover.schedulevisualizer.ui.elements;

import edu.hanover.schedulevisualizer.core.Course;
import edu.hanover.schedulevisualizer.observable.MyObserver;
import javafx.application.Platform;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.List;

public class UnassignedCourseList extends VBox implements MyObserver<List<Course>> {

    void addCourse(Course course) {
        getChildren().add(CourseEntry.forCourse(course));
    }

    public void update(List<Course> courses) {
        Platform.runLater(() -> displayData(courses));
    }

    private void displayData(List<Course> courses) {
        courses.forEach(this::displayCourse);
    }

    private void displayCourse(Course course) {
        course.getTimeslot().ifUnassignedSlotDo(() -> addCourse(course));
    }

    public void setAsDropTarget() {
        setOnDragOver(
                event -> {
                    if (event.getGestureSource() != this &&
                            event.getDragboard().hasString()) {
                        System.out.println("Accepted modes: " + event.getDragboard().getTransferModes());
                        System.out.println("Default mode: " + event.getTransferMode());
                        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                    }

                    event.consume();
                });
        setOnDragEntered(event -> {
            if (event.getGestureSource() != this &&
                    event.getDragboard().hasString()) {
                setBorder(Border.stroke(Color.BLUEVIOLET));
            }

            event.consume();
        });
        setOnDragExited(event -> {
            setBorder(Border.EMPTY);
            event.consume();
        });
        setOnDragDropped(event -> {
            /* data dropped */
            /* if there is a string data on dragboard, read it and use it */
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasString()) {
                System.out.println(event.getTransferMode());
                System.out.println(event.getAcceptedTransferMode());
                System.out.println("Dropped: " + db.getString());
                success = true;
            }
            /* let the source know whether the string was successfully
             * transferred and used */
            event.setDropCompleted(success);

            event.consume();
        });
    }
}
