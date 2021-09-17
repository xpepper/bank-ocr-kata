package com.kata.bankocr;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

public class BankOCR {
    private final LineReader lineReader;
    private final AccountNumberParser accountNumberParser;

    public BankOCR(LineReader lineReader, AccountNumberParser accountNumberParser) {
        this.lineReader = lineReader;
        this.accountNumberParser = accountNumberParser;
    }

    public List<String> parseAccountNumbers() {
        List<String> lines = lineReader.readLines();
        if (lines.isEmpty())
            return emptyList();

        List<String> accountNumbers = new ArrayList<>();
        for (int i = 0; i < lines.size(); i += 4) {
            String accountNumber = accountNumberParser.parse(new AccountNumberRow(lines.get(i), lines.get(i + 1), lines.get(i + 2)));
            accountNumbers.add(accountNumber);
        }

        return accountNumbers;
    }
}
