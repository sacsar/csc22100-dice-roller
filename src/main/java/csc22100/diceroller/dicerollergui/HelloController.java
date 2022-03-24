package csc22100.diceroller.dicerollergui;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class HelloController {
    @FXML private MenuItem settings;

    @FXML
    private Label roll;

    @FXML
    private Button button;

    @FXML
    private MenuItem quit;

    private DiceRollerViewModel viewModel;

    private HelloApplication helloApplication;

    public void init(DiceRollerViewModel viewModel, HelloApplication helloApplication) {
        this.viewModel = viewModel;
        this.helloApplication = helloApplication;
        // Now, let's bind/set up the remaining things
        quit.setOnAction((ev) -> Platform.exit());

        roll.visibleProperty().bind(viewModel.hasRoll());
        roll.textProperty().bind(
                Bindings.createStringBinding(() -> Integer.toString(viewModel.currentRoll().get()),
                        viewModel.currentRoll()));

        // bind the settings option to open the settings window
        settings.setOnAction((ev) -> helloApplication.openSettingsWindow());
    }

    public void onRoll(ActionEvent actionEvent) {
        viewModel.roll();
    }
}