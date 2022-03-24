package csc22100.diceroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class DiceRollingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiceRollingService.class);
    private static final Random random = new Random();

    private int numDice;
    private DiceType diceType;

    public DiceRollingService() {
        this(6, DiceType.d6);
    }

    public DiceRollingService(int numDice, DiceType diceType) {
        this.numDice = numDice;
        this.diceType = diceType;
    }

    public int roll() {
        return roll(numDice);
    }

    public int roll(int numSides) {
        int result = random.nextInt(numSides) + 1;
        LOGGER.info("Rolled a {}", result);
        return result;
    }

    public int getNumDice() {
        return numDice;
    }

    public void setNumDice(int numDice) {
        this.numDice = numDice;
    }

    public DiceType getDiceType() {
        return diceType;
    }

    public void setDiceType(DiceType diceType) {
        this.diceType = diceType;
    }
}
