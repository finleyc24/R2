package edu.hanover.schedulevisualizer.ui.draganddrop;

import javafx.scene.input.Dragboard;

public interface DropPerformer {
    boolean executeTheDrop(DropTarget target, Dragboard db);
}
