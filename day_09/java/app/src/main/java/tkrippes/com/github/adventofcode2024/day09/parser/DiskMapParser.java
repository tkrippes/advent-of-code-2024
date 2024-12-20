package tkrippes.com.github.adventofcode2024.day09.parser;

import tkrippes.com.github.adventofcode2024.day09.DiskMap;
import tkrippes.com.github.adventofcode2024.day09.disk.File;
import tkrippes.com.github.adventofcode2024.day09.disk.FilesystemEntity;
import tkrippes.com.github.adventofcode2024.day09.disk.FreeSpace;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DiskMapParser {
    public static DiskMap parse(String inputFileName) throws IOException {
        java.io.File inputFile = new java.io.File(inputFileName);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("Could not find input file: " + inputFileName);
        }

        DiskMap map;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            map = parseDiskMap(String.join("", reader.lines().toList()));
            reader.close();
        } catch (IOException e) {
            throw new IOException("Error reading file: " + inputFile, e);
        }

        return map;
    }

    private static DiskMap parseDiskMap(String input) {
        List<FilesystemEntity> filesystem = new ArrayList<>();

        int currentFileId = 0;
        for (int i = 0; i < input.length(); i += 2) {
            filesystem.add(new File(Character.getNumericValue(input.charAt(i)), currentFileId));
            if (i + 1 < input.length()) {
                filesystem.add(new FreeSpace(Character.getNumericValue(input.charAt(i + 1))));
            }

            currentFileId++;
        }

        return new DiskMap(filesystem);
    }
}
