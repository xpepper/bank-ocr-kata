package com.kata.bankocr;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class BankOCR {
    private static final int ACCOUNT_NUMBER_ENTRY_SIZE = 4;
    public static final int DIGIT_SIZE = 3;

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

        return IntStream.iterate(0, i -> i < lines.size(), i -> i + ACCOUNT_NUMBER_ENTRY_SIZE)
                .mapToObj(i -> toAccountNumber(lines, i))
                .collect(toList());
    }

    private String toAccountNumber(List<String> lines, int i) {
        List<String> rows = lines.subList(i, i + DIGIT_SIZE);
        AccountNumberRows accountNumberRows = new AccountNumberRows(rows.get(0), rows.get(1), rows.get(2));
        return accountNumberParser.parse(accountNumberRows);
    }
}
