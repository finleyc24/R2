package edu.hanover.schedulevisualizer.ui.controller;

import edu.hanover.schedulevisualizer.core.Context;
import edu.hanover.schedulevisualizer.ui.elements.SidePanel;
import edu.hanover.schedulevisualizer.ui.elements.UnassignedCourseList;
import javafx.fxml.FXML;

public class SidePanelController {
    @FXML
    public SidePanel panel;

    @FXML
    public UnassignedCourseList unassignedCourseList;

    @FXML
    public void initialize() {
        Context context = Context.getInstance();
        context.addObserver(unassignedCourseList);
    }
}
