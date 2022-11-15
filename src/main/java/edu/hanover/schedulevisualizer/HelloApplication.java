package edu.hanover.schedulevisualizer;

import edu.hanover.schedulevisualizer.core.Context;
import edu.hanover.schedulevisualizer.ui.App;
import javafx.application.Application;
import javafx.scene.image.Image;
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
        launch();
    }
}