package com.kata.bankocr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BankOCRKataTest {

    private static final List<String> ONE_ACCOUNT_NUMBER = asList(
            "line1",
            "line2",
            "line3",
            ""
    );
    private static final List<String> ANOTHER_ACCOUNT_NUMBER = asList(
            "another line1",
            "another line2",
            "another line3",
            ""
    );
    private static final AccountNumber ANY_ACCOUNT_NUMBER = new AccountNumber("a number");

    private final LineReader lineReader = mock(LineReader.class);
    private final AccountNumberParser parser = mock(AccountNumberParser.class);
    private final ReportWriter reportWriter = mock(ReportWriter.class);

    private BankOCR bankOCR;

    @BeforeEach
    void setUp() {
        bankOCR = new BankOCR(lineReader, parser, reportWriter);
    }

    @Test
    void scanning_an_empty_stream_of_lines_results_in_an_empty_list_of_account_numbers() {
        when(lineReader.readLines()).thenReturn(emptyList());

        List<AccountNumber> accountNumbers = bankOCR.scanAccountNumbers();

        assertThat(accountNumbers).isEmpty();
    }

    @Test
    void scan_two_account_numbers() {
        when(lineReader.readLines()).thenReturn(linesOf(ONE_ACCOUNT_NUMBER, ANOTHER_ACCOUNT_NUMBER));
        when(parser.parse(new AccountNumberRows("line1", "line2", "line3"))).thenReturn(new AccountNumber("a number"));
        when(parser.parse(new AccountNumberRows("another line1", "another line2", "another line3"))).thenReturn(new AccountNumber("another number"));

        List<AccountNumber> accountNumbers = bankOCR.scanAccountNumbers();

        assertThat(accountNumbers).isEqualTo(asList(new AccountNumber("a number"), new AccountNumber("another number")));
    }

    @Test
    void writes_an_OCR_scanning_report_at_the_end() {
        when(lineReader.readLines()).thenReturn(asList("line1", "line2", "line3"));
        when(parser.parse(any())).thenReturn(ANY_ACCOUNT_NUMBER);

        bankOCR.scanAccountNumbers();

        verify(reportWriter).writeFor(asList(ANY_ACCOUNT_NUMBER));
    }

    private List<String> linesOf(List<String> oneAccountNumber, List<String> anotherAccountNumber) {
        return flatten(oneAccountNumber, anotherAccountNumber);
    }

    private List<String> flatten(List<String> list, List<String> anotherList) {
        return Stream.of(list, anotherList).flatMap(Collection::stream).collect(toList());
    }
}
