package tkrippes.com.github.adventofcode2024.day11;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlutonianPebbleTest {
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void blinkOnZeroPebbleShouldReturnOnePebble() {
        PlutonianPebble stone = new PlutonianPebble(0);

        assertEquals(List.of(new PlutonianPebble(1)), stone.blink());
    }

    @Test
    public void blinkOnOnePebbleShouldReturnMultipliedPebble() {
        PlutonianPebble stone = new PlutonianPebble(1);

        assertEquals(List.of(new PlutonianPebble(2024)), stone.blink());
    }

    @Test
    public void blinkOnTenPebbleShouldReturnSplitPebble() {
        PlutonianPebble stone = new PlutonianPebble(10);

        assertEquals(List.of(new PlutonianPebble(1), new PlutonianPebble(0)), stone.blink());
    }

    @Test
    public void blinkOnNinetyNinePebbleShouldReturnSplitPebble() {
        PlutonianPebble stone = new PlutonianPebble(99);

        assertEquals(List.of(new PlutonianPebble(9), new PlutonianPebble(9)), stone.blink());
    }

    @Test
    public void blinkOnThousandPebbleShouldReturnSplitPebble() {
        PlutonianPebble stone = new PlutonianPebble(1000);

        assertEquals(List.of(new PlutonianPebble(10), new PlutonianPebble(0)), stone.blink());
    }

    @Test
    public void blinkOnNineHundredNinetyNinePebbleShouldReturnMultipliedPebble() {
        PlutonianPebble stone = new PlutonianPebble(999);

        assertEquals(List.of(new PlutonianPebble(2021976)), stone.blink());
    }

    @AfterEach
    public void tearDown() {
    }
}
