package csc22100.diceroller.dicerollergui;

import csc22100.diceroller.DiceRollingService;
import csc22100.diceroller.DiceType;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class SettingsViewModel {
    private final ObjectProperty<DiceType> diceType;

    private final IntegerProperty numDice;

    private final DiceRollingService diceRollingService;

    public SettingsViewModel(DiceRollingService diceRollingService) {
        this.diceRollingService = diceRollingService;
        this.diceType = new SimpleObjectProperty<>(diceRollingService.getDiceType());
        this.numDice = new SimpleIntegerProperty(diceRollingService.getNumDice());
    }

    public IntegerProperty numDice() {
        return numDice;
    }

    public ObjectProperty<DiceType> diceType() {
        return diceType;
    }

    public void saveSettings() {
        diceRollingService.setDiceType(diceType.getValue());
        diceRollingService.setNumDice(numDice.getValue());
    }
}
