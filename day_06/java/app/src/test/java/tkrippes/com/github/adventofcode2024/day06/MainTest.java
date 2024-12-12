package tkrippes.com.github.adventofcode2024.day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void appHasAGreeting() {
        Main classUnderTest = new Main();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
