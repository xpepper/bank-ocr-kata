import com.kata.bankocr.AccountNumberParser;
import com.kata.bankocr.AccountNumberRow;
import com.kata.bankocr.BankOCR;
import com.kata.bankocr.LineReader;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BankOCRKataTest {

    private static final List<String> ONE_ACCOUNT_NUMBER = Arrays.asList(
            "line1",
            "line2",
            "line3",
            ""
    );
    private static final List<String> ANOTHER_ACCOUNT_NUMBER = Arrays.asList(
            "another line1",
            "another line2",
            "another line3",
            ""
    );

    private final LineReader lineReader = mock(LineReader.class);
    private final AccountNumberParser accountNumberParser = mock(AccountNumberParser.class);

    @Test
    void parsing_an_empty_stream_of_files_results_in_an_empty_list_of_account_numbers() {
        when(lineReader.readLines()).thenReturn(emptyList());

        List<String> accountNumbers = new BankOCR(lineReader, accountNumberParser).parseAccountNumbers();

        assertThat(accountNumbers).isEmpty();
    }

    @Test
    void parse_a_single_account_number() {
        when(lineReader.readLines()).thenReturn(ONE_ACCOUNT_NUMBER);
        when(accountNumberParser.parse(new AccountNumberRow("line1", "line2", "line3"))).thenReturn("an account number");

        List<String> accountNumbers = new BankOCR(lineReader, accountNumberParser).parseAccountNumbers();

        assertThat(accountNumbers).isEqualTo(List.of("an account number"));
    }

    @Test
    void parse_two_account_numbers() {
        List<String> lines = Stream.of(ONE_ACCOUNT_NUMBER, ANOTHER_ACCOUNT_NUMBER).flatMap(Collection::stream).collect(Collectors.toList());
        when(lineReader.readLines()).thenReturn(lines);
        when(accountNumberParser.parse(new AccountNumberRow("line1", "line2", "line3"))).thenReturn("an account number");
        when(accountNumberParser.parse(new AccountNumberRow("another line1", "another line2", "another line3"))).thenReturn("another account number");

        List<String> accountNumbers = new BankOCR(lineReader, accountNumberParser).parseAccountNumbers();

        assertThat(accountNumbers).isEqualTo(List.of("an account number", "another account number"));
    }

}
