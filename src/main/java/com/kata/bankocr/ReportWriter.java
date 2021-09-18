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
                .map(AccountNumber::toString)
                .collect(toList());
        
        reportStorage.save(lines);
    }
}
