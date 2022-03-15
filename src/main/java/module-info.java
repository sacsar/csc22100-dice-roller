module diceroller.gui.main {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.slf4j;


    opens csc22100.diceroller.dicerollergui to javafx.fxml;
    exports csc22100.diceroller.dicerollergui;
    exports csc22100.diceroller;
}