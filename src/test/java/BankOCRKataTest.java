import com.kata.bankocr.BankOCR;
import com.kata.bankocr.LineReader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Collections.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class BankOCRKataTest {

    private final LineReader lineReader = mock(LineReader.class);

    @Test
    void parsing_an_empty_stream_of_files_results_in_an_empty_list_of_account_numbers() {
        when(lineReader.readLines()).thenReturn(emptyList());

        List<String> accountNumbers = new BankOCR(lineReader).parseAccountNumbers();

        assertThat(accountNumbers).isEmpty();
    }
}
