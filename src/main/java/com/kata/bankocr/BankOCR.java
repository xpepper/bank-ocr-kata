package com.kata.bankocr;

import java.util.List;
import java.util.stream.IntStream;

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

    public List<AccountNumber> parseAccountNumbers() {
        List<String> lines = lineReader.readLines();

        return chunkOf(ACCOUNT_NUMBER_ENTRY_SIZE, lines.size())
                .mapToObj(i -> toAccountNumber(lines.subList(i, i + DIGIT_SIZE)))
                .collect(toList());
    }

    private IntStream chunkOf(int accountNumberEntrySize, int size) {
        return IntStream.iterate(0, i -> i < size, i -> i + accountNumberEntrySize);
    }

    private AccountNumber toAccountNumber(List<String> rows) {
        AccountNumberRows accountNumberRows = new AccountNumberRows(rows.get(0), rows.get(1), rows.get(2));
        return accountNumberParser.parse(accountNumberRows);
    }
}
