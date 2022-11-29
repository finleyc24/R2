package edu.hanover.schedulevisualizer.ui.draganddrop;

import javafx.scene.Node;

public interface DropTarget {
    void clearValidDropTarget();
    void signalValidDropTarget();

    String getTimeslotId();

    Node getNode();
}
