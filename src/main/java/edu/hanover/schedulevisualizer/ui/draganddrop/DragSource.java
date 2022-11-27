package edu.hanover.schedulevisualizer.ui.draganddrop;

import javafx.scene.Node;

public interface DragSource {
    String getDraggedContent();

    void indicateDragEnded();

    void indicateDragStarted();

    Node getNode();
}
