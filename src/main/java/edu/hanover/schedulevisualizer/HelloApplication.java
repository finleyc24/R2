package edu.hanover.schedulevisualizer;

import edu.hanover.schedulevisualizer.core.Context;
import edu.hanover.schedulevisualizer.ui.App;
import edu.hanover.schedulevisualizer.ui.draganddrop.DragAndDropController;
import edu.hanover.schedulevisualizer.ui.draganddrop.DropPerformer;
import edu.hanover.schedulevisualizer.ui.draganddrop.DropTarget;
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
        DragAndDropController.getInstance().setDropPerformer(new DropPerformer() {
            // Add methods to call on Context.getInstance()
            public boolean executeTheDrop(DropTarget target, Dragboard db) {
                Long courseId = Long.valueOf(db.getString());
                String timeslotId = target.getTimeslotId();
                Context.getInstance().moveCourseToTimeslot(courseId, timeslotId);
                return true;
            }

        });
        launch();
    }
}