package edu.hanover.schedulevisualizer.ui.elements;

import javafx.scene.Node;

public interface DragSource {
    String getDraggedContent();

    void indicateDragEnded();

    void indicateDragStarted();

    Node getNode();
}
