package csc22100.diceroller.dicerollergui;

import csc22100.diceroller.DiceRollingService;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableIntegerValue;

public class DiceRollerViewModel {

    private final DiceRollingService service;

    private final IntegerProperty currentRoll = new SimpleIntegerProperty();

    private final BooleanProperty hasRoll = new SimpleBooleanProperty(false);

    public DiceRollerViewModel(DiceRollingService service) {
        this.service = service;
    }

    public void roll() {
        int result = service.roll(6); // What do we do with this result?
        currentRoll.setValue(result);
        hasRoll.setValue(true);
    }

    // Properties are "observable" and can be "bound" to fields in the view
    public ObservableIntegerValue currentRoll() {
        return currentRoll;
    }

    public ObservableBooleanValue hasRoll() {
        return hasRoll;
    }
}
