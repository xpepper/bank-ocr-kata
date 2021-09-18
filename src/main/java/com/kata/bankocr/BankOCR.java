package com.kata.bankocr;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class BankOCR {
    private static final int ACCOUNT_NUMBER_ENTRY_SIZE = 4;
    public static final int DIGIT_SIZE = 3;

    private final LineReader lineReader;
    private final AccountNumberParser accountNumberParser;
    private final ReportWriter reportWriter;

    public BankOCR(LineReader lineReader, AccountNumberParser accountNumberParser, ReportWriter reportWriter) {
        this.lineReader = lineReader;
        this.accountNumberParser = accountNumberParser;
        this.reportWriter = reportWriter;
    }

    public List<AccountNumber> parseAccountNumbers() {
        List<String> lines = lineReader.readLines();

        List<AccountNumber> accountNumbers = parse(lines);

        reportWriter.writeFor(accountNumbers);

        return accountNumbers;
    }

    private List<AccountNumber> parse(List<String> lines) {
        List<AccountNumber> accountNumbers = chunkOf(ACCOUNT_NUMBER_ENTRY_SIZE, lines.size())
                .mapToObj(i -> toAccountNumber(lines.subList(i, i + DIGIT_SIZE)))
                .collect(toList());
        return accountNumbers;
    }

    private IntStream chunkOf(int accountNumberEntrySize, int size) {
        return IntStream.iterate(0, i -> i < size, i -> i + accountNumberEntrySize);
    }

    private AccountNumber toAccountNumber(List<String> rows) {
        AccountNumberRows accountNumberRows = new AccountNumberRows(rows.get(0), rows.get(1), rows.get(2));
        return accountNumberParser.parse(accountNumberRows);
    }
}
