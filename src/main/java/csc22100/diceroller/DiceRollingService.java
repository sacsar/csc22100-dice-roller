package csc22100.diceroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class DiceRollingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiceRollingService.class);
    private static final Random random = new Random();

    public int roll(int numSides) {
        int result = random.nextInt(numSides) + 1;
        LOGGER.info("Rolled a {}", result);
        return result;
    }
}
