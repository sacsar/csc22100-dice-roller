package csc22100.diceroller.dicerollergui;

import csc22100.diceroller.DiceType;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SettingsController {
    @FXML
    private ChoiceBox<DiceType> diceType;

    @FXML
    private ChoiceBox<Integer> numDice;

    @FXML
    private Button cancelButton;

    @FXML
    private Button saveButton;

    private SettingsViewModel viewModel;

    public void init(SettingsViewModel viewModel) {
        this.viewModel = viewModel;

        // first, populate our dropdowns
        diceType.setItems(
                FXCollections.observableList(Arrays.asList(DiceType.values())));
        diceType.valueProperty().bindBidirectional(viewModel.diceType());

        numDice.setItems(FXCollections.observableList(
                IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList())
        ));
        numDice.valueProperty().bind(
                Bindings.createObjectBinding(() -> viewModel.numDice().getValue(),
                        viewModel.numDice()));
        numDice.valueProperty().addListener((ev) ->
                viewModel.numDice().setValue(numDice.getValue()));

        cancelButton.setOnAction((ev) -> {
            // close the window!? We need to call close on the *stage*
        });

        saveButton.setOnAction((ev) -> {
            viewModel.saveSettings();
            // close the window!?
        });
    }
}
