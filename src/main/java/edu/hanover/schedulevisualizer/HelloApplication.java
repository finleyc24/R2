package edu.hanover.schedulevisualizer;

import edu.hanover.schedulevisualizer.core.Context;
import edu.hanover.schedulevisualizer.core.Course;
import edu.hanover.schedulevisualizer.core.TimeSlot;
import edu.hanover.schedulevisualizer.ui.App;
import edu.hanover.schedulevisualizer.ui.draganddrop.DragAndDropController;
import edu.hanover.schedulevisualizer.ui.draganddrop.DropExecutor;
import edu.hanover.schedulevisualizer.ui.draganddrop.DropTarget;
import edu.hanover.schedulevisualizer.ui.elements.CourseEntry;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.input.Dragboard;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private final App app = new App();

    @Override
    public void start(Stage stage) throws IOException {
        stage.getIcons().add(new Image(HelloApplication.class.getResourceAsStream("icon.png")));
        app.startApp(stage);
        Thread thread = new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000);
                    Context.getInstance().getData();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        thread.start();
    }

    public static void main(String[] args) {
        DragAndDropController.getInstance().setDropExecutor(new DropExecutor() {
            // Add methods to call on Context.getInstance()
            public boolean executeTheDrop(DropTarget target, Dragboard db) {
                Course course = Context.getInstance().getCourseWithId(Long.valueOf(db.getString()));
                TimeSlot timeslot = target.getTimeslot();
                course.setTimeslot(timeslot);
                System.out.println("Dropped: " + course + timeslot);
                return true;
            }

        });
        launch();
    }
}