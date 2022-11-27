package edu.hanover.schedulevisualizer.ui.draganddrop;

import javafx.scene.input.Dragboard;

public interface DropExecutor {
    boolean executeTheDrop(DropTarget target, Dragboard db);
}
