package tkrippes.com.github.adventofcode2024.day13.parser;

import tkrippes.com.github.adventofcode2024.day13.Direction;
import tkrippes.com.github.adventofcode2024.day13.MachineConfiguration;
import tkrippes.com.github.adventofcode2024.day13.Position;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MachineConfigurationsParser {
    public static List<MachineConfiguration> parse(String inputFileName) throws IOException {
        File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Could not find input file: " + inputFileName);
        }

        List<MachineConfiguration> machineConfigurations;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            machineConfigurations = parseMachineConfigurations(reader.lines().toList());
            reader.close();
        } catch (IOException e) {
            throw new IOException("Error reading file: " + inputFile, e);
        }

        return machineConfigurations;
    }

    private static List<MachineConfiguration> parseMachineConfigurations(List<String> inputLines) {
        List<List<String>> machineConfigurationInputs = new ArrayList<>(List.of(new ArrayList<>()));
        for (String inputLine : inputLines) {
            if (inputLine.trim().isEmpty()) {
                machineConfigurationInputs.add(new ArrayList<>());
            } else {
                machineConfigurationInputs.getLast().add(inputLine);
            }
        }

        return machineConfigurationInputs.stream().map(MachineConfigurationsParser::parseMachineConfiguration).toList();
    }

    private static MachineConfiguration parseMachineConfiguration(List<String> machineConfigurationInput) {
        return new MachineConfiguration(parseButtonBehaviour(machineConfigurationInput.get(0)),
                parseButtonBehaviour(machineConfigurationInput.get(1)),
                parsePrizeLocation(machineConfigurationInput.get(2)));
    }

    private static Direction parseButtonBehaviour(String buttonBehaviorInput) {
        String regex = "X\\+(\\d+), Y\\+(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(buttonBehaviorInput);

        if (matcher.find()) {
            return new Direction(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
        }

        return new Direction(-1, -1);
    }

    private static Position parsePrizeLocation(String prizeLocationInput) {
        String regex = "X=(\\d+), Y=(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(prizeLocationInput);

        if (matcher.find()) {
            return new Position(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
        }

        return new Position(-1, -1);
    }
}
