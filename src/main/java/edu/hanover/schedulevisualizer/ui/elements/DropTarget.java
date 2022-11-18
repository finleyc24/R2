package edu.hanover.schedulevisualizer.ui.elements;

import edu.hanover.schedulevisualizer.core.TimeSlot;
import javafx.scene.Node;

public interface DropTarget {
    void clearValidDropTarget();
    void signalValidDropTarget();

    TimeSlot getTimeslot();
    Node getNode();

}
