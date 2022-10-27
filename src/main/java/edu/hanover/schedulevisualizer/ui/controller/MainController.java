package edu.hanover.schedulevisualizer.ui.controller;

import edu.hanover.schedulevisualizer.ui.elements.SidePanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {
    @FXML
    SidePanel sidePanel;
    @FXML
    Button sidePanelButton;

    private boolean panelVisible = false;

    public void onToggleSidePanel(ActionEvent event) {
        setPanelVisible(!getPanelVisible());
    }

    public void initialize() {
        setPanelVisible(false);
    }

    boolean getPanelVisible() {
        return panelVisible;
    }

    void setPanelVisible(boolean panelVisible) {
        this.panelVisible = panelVisible;
        sidePanel.setVisible(panelVisible);
        sidePanel.setManaged(panelVisible);
        sidePanelButton.setText(panelVisible ? "<<<" : ">>>");
    }
}
