package tkrippes.com.github.adventofcode2024.day11;

import java.util.List;

public record PlutonianPebble(long number) {
    public List<PlutonianPebble> blink() {
        if (isZero()) {
            return List.of(new PlutonianPebble(1));
        }

        if (hasEvenNumberOfDigits()) {
            return getSplitPebble();
        }

        return List.of(new PlutonianPebble(number * 2024));
    }

    private boolean isZero() {
        return number == 0;
    }

    private boolean hasEvenNumberOfDigits() {
        return String.valueOf(number).length() % 2 == 0;
    }

    private List<PlutonianPebble> getSplitPebble() {
        String numberString = String.valueOf(number);
        int splitPosition = numberString.length() / 2;

        return List.of(new PlutonianPebble(Long.parseLong(numberString.substring(0, splitPosition))),
                new PlutonianPebble(Long.parseLong(numberString.substring(splitPosition))));
    }
}
