package csc22100.diceroller.dicerollergui;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class HelloController {
    @FXML
    private Label roll;

    @FXML
    private Button button;

    @FXML
    MenuItem quit;

    DiceRollerViewModel viewModel;

    public void init(DiceRollerViewModel viewModel) {
        this.viewModel = viewModel;
        // Now, let's bind/set up the remaining things
        quit.setOnAction((ev) -> Platform.exit());

        roll.visibleProperty().bind(viewModel.hasRoll());
        roll.textProperty().bind(
                Bindings.createStringBinding(() -> Integer.toString(viewModel.currentRoll().get()),
                        viewModel.currentRoll()));
    }

    public void onRoll(ActionEvent actionEvent) {
        viewModel.roll();
    }
}