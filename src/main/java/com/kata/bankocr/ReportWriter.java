package com.kata.bankocr;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ReportWriter {
    private final ReportStorage reportStorage;

    public ReportWriter(ReportStorage reportStorage) {
        this.reportStorage = reportStorage;
    }

    public void writeFor(List<AccountNumber> accountNumbers) {
        List<String> lines = accountNumbers.stream()
                .map(accountNumber -> format(accountNumber))
                .collect(toList());

        reportStorage.save(lines);
    }

    private String format(AccountNumber accountNumber) {
        return accountNumber.toString() + (!accountNumber.isValid() ? " ERR" : "");
    }
}
