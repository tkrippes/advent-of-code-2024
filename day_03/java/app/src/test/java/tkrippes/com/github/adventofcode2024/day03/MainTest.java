package tkrippes.com.github.adventofcode2024.day03;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void appHasAGreeting() {
        Main classUnderTest = new Main();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}
