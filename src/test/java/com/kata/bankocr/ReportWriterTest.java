package com.kata.bankocr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReportWriterTest {

    private final ReportStorage reportStorage = mock(ReportStorage.class);

    private ReportWriter reportWriter;

    @BeforeEach
    void setUp() {
        reportWriter = new ReportWriter(reportStorage);
    }

    @Test
    void writes_a_report_for_valid_account_numbers() {
        AccountNumber validAccountNumber = new AccountNumber("457508000");
        AccountNumber anotherValidAccountNumber = new AccountNumber("345882865");

        reportWriter.writeFor(asList(validAccountNumber, anotherValidAccountNumber));

        verify(reportStorage).save(asList("457508000", "345882865"));
    }

    @Test
    void writes_a_report_containing_invalid_an_account_number() {
        AccountNumber valid = new AccountNumber("457508000");
        AccountNumber invalid = new AccountNumber("123123123");

        reportWriter.writeFor(asList(valid, invalid));

        verify(reportStorage).save(asList("457508000", "123123123 ERR"));
    }
}
