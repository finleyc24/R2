package edu.hanover.schedulevisualizer.ui.controller;

import edu.hanover.schedulevisualizer.core.Course;
import edu.hanover.schedulevisualizer.core.TimeSlot;
import edu.hanover.schedulevisualizer.ui.elements.CourseEntry;
import edu.hanover.schedulevisualizer.ui.elements.DragSource;
import edu.hanover.schedulevisualizer.ui.elements.DropTarget;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class DragAndDropController {
    private final static DragAndDropController instance = new DragAndDropController();

    public static DragAndDropController getInstance() {
        return instance;
    }

    private DragAndDropController() {}

    public void setupDropTarget(DropTarget target) {
        setupOnDragOver(target);
        setupOnDragEntered(target);
        setupOnDragExited(target);
        setupOnDragDropped(target);
    }

    public void setupDragSource(DragSource source) {
        source.getNode().setOnDragDetected(event -> {
            Dragboard db = source.getNode().startDragAndDrop(TransferMode.ANY);

            ClipboardContent content = new ClipboardContent();
            content.putString(source.getDraggedContent());
            db.setContent(content);
            source.indicateDragStarted();
            event.consume();
        });
        source.getNode().setOnDragDone(event -> {
            source.indicateDragEnded();
        });
    }


    private void setupOnDragDropped(DropTarget target) {
        target.getNode().setOnDragDropped(event -> {
            // TODO: needs to move correct version of this code to actual target
            boolean success = completeTheDragAndDrop(event, target);
            event.setDropCompleted(success);

            event.consume();
        });
    }

    private boolean completeTheDragAndDrop(DragEvent event, DropTarget target) {
        Dragboard db = event.getDragboard();

        if (db.hasString()) {
            Object source = event.getGestureSource();
            if (! (source instanceof CourseEntry)) return false;
            CourseEntry courseEntry = (CourseEntry) source;
            Course course = courseEntry.getCourse();
            TimeSlot timeslot = target.getTimeslot();
            course.setTimeslot(timeslot);
            System.out.println("Dropped: " + course + timeslot);
            return true;
        }
        return false;
    }

    private void setupOnDragExited(DropTarget target) {
        target.getNode().setOnDragExited(event -> {
            target.clearValidDropTarget();
            event.consume();
        });
    }

    private void setupOnDragEntered(DropTarget target) {
        target.getNode().setOnDragEntered(event -> {
            if (isValidSourceAndContent(event, target)) {
                target.signalValidDropTarget();
            }

            event.consume();
        });
    }

    private boolean isValidSourceAndContent(DragEvent event, DropTarget target) {
        return containsGestureSource(event.getGestureSource(), target) &&
                isValidDragboardContent(event);
    }

    private static boolean isValidDragboardContent(DragEvent event) {
        return event.getDragboard().hasString();
    }

    private boolean containsGestureSource(Object gestureSource, DropTarget target) {
        // TODO: Not exactly what it says, allows self-drops
        return gestureSource != target;
    }

    private void setupOnDragOver(DropTarget target) {
        target.getNode().setOnDragOver(
                event -> {
                    if (isValidSourceAndContent(event, target)) {
                        System.out.println("Accepted modes: " + event.getDragboard().getTransferModes());
                        System.out.println("Default mode: " + event.getTransferMode());
                        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                    }

                    event.consume();
                });
    }
}