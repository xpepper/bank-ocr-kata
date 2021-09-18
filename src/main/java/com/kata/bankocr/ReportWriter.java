package com.kata.bankocr;

import java.util.List;

public interface ReportWriter {
    void writeFor(List<AccountNumber> accountNumbers);
}
