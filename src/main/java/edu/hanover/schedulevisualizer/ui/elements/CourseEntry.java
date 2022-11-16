package edu.hanover.schedulevisualizer.ui.elements;

import edu.hanover.schedulevisualizer.core.Course;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class CourseEntry extends StackPane {
    @FXML
    Rectangle background;
    @FXML
    Label label;

    public CourseEntry() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "course-entry-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
            setupAsDragSource();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private void setupAsDragSource() {
        setOnDragDetected(event -> {
            Dragboard db = startDragAndDrop(TransferMode.ANY);

            ClipboardContent content = new ClipboardContent();
            content.putString(getText());
            db.setContent(content);
            // TODO: Make drag color change
            setColor(Color.AZURE);
            event.consume();
        });
        setOnDragDone(event -> {
            setColor(Color.AQUA);
        });
    }

    static CourseEntry forCourse(Course course) {
        CourseEntry entry = new CourseEntry();
        entry.setText(course.getCourseCode());
        entry.setColor(Color.AQUA);
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
}
