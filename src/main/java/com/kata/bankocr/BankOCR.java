package com.kata.bankocr;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

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

        return IntStream.iterate(0, i -> i < lines.size(), i -> i + 4)
                .mapToObj(i -> toAccountNumber(lines, i))
                .collect(toList());
    }

    private String toAccountNumber(List<String> lines, int i) {
        AccountNumberRow accountNumberRow = new AccountNumberRow(lines.get(i), lines.get(i + 1), lines.get(i + 2));
        return accountNumberParser.parse(accountNumberRow);
    }
}
