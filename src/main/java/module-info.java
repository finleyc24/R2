module edu.hanover.schedulevisualizer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
//    requires eu.hansolo.tilesfx;
    requires javafx.graphics;

    opens edu.hanover.schedulevisualizer to javafx.fxml;
    exports edu.hanover.schedulevisualizer;
}