package edu.hanover.schedulevisualizer.ui.controller;

import edu.hanover.schedulevisualizer.core.Course;
import edu.hanover.schedulevisualizer.core.TimeSlot;
import edu.hanover.schedulevisualizer.ui.elements.CourseEntry;
import edu.hanover.schedulevisualizer.ui.elements.DropTarget;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class DropTargetController {
    private final DropTarget target;

    public DropTargetController(DropTarget target) {
        this.target = target;
    }

    public void setup() {
        setupOnDragOver();
        setupOnDragEntered();
        setupOnDragExited();
        setupOnDragDropped();
    }

    private void setupOnDragDropped() {
        target.getNode().setOnDragDropped(event -> {
            // TODO: needs to move correct version of this code to actual target
            boolean success = completeTheDragAndDrop(event);
            event.setDropCompleted(success);

            event.consume();
        });
    }

    private boolean completeTheDragAndDrop(DragEvent event) {
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

    private void setupOnDragExited() {
        target.getNode().setOnDragExited(event -> {
            target.clearValidDropTarget();
            event.consume();
        });
    }

    private void setupOnDragEntered() {
        target.getNode().setOnDragEntered(event -> {
            if (isValidSourceAndContent(event)) {
                target.signalValidDropTarget();
            }

            event.consume();
        });
    }

    private boolean isValidSourceAndContent(DragEvent event) {
        return containsGestureSource(event.getGestureSource()) &&
                isValidDragboardContent(event);
    }

    private static boolean isValidDragboardContent(DragEvent event) {
        return event.getDragboard().hasString();
    }

    private boolean containsGestureSource(Object gestureSource) {
        // TODO: Not exactly what it says, allows self-drops
        return gestureSource != target;
    }

    private void setupOnDragOver() {
        target.getNode().setOnDragOver(
                event -> {
                    if (isValidSourceAndContent(event)) {
                        System.out.println("Accepted modes: " + event.getDragboard().getTransferModes());
                        System.out.println("Default mode: " + event.getTransferMode());
                        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                    }

                    event.consume();
                });
    }
}