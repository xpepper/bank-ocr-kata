package com.kata.bankocr;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReportWriterTest {

    private ReportStorage reportStorage = mock(ReportStorage.class);

    @Test
    void writes_a_report_for_valid_account_numbers() {
        AccountNumber validAccountNumber = new AccountNumber("457508000");
        AccountNumber anotherValidAccountNumber = new AccountNumber("345882865");

        new ReportWriter(reportStorage).writeFor(asList(validAccountNumber, anotherValidAccountNumber));
        
        verify(reportStorage).save(asList("457508000", "345882865"));
    }
}
