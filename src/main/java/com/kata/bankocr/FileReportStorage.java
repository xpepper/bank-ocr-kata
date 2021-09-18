package com.kata.bankocr;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileReportStorage implements ReportStorage {
    private final String filePath;

    public FileReportStorage(String filePath) {

        this.filePath = filePath;
    }

    @Override public void save(List<String> lines) {
        try (FileWriter fileWriter = new FileWriter(filePath);) {
            for (String line : lines) {
                fileWriter.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
