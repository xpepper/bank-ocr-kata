package com.kata.bankocr;

import java.util.List;

import static java.util.Collections.*;

public class BankOCR {
    private final LineReader lineReader;

    public BankOCR(LineReader lineReader) {
        this.lineReader = lineReader;
    }

    public List<String> parseAccountNumbers() {
        List<String> lines = lineReader.readLines();
        if (lines.isEmpty())
            return emptyList();

        return null;
    }
}
