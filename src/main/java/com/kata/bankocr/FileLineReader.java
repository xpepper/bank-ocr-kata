package com.kata.bankocr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FileLineReader implements LineReader {
    private final String filePath;

    public FileLineReader(String filePath) {
        this.filePath = filePath;
    }

    @Override public List<String> readLines() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            return fileReader.lines().collect(toList());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("cannot find file " + filePath);
        }
    }
}
