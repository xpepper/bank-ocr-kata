package com.kata.bankocr;

import java.util.List;
import java.util.stream.IntStream;

import static com.kata.bankocr.BankOCR.DIGIT_SIZE;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AccountNumberParser {

    public AccountNumber parse(AccountNumberRows accountNumberRows) {

        List<String> allRow1s = splitByNumber(accountNumberRows.row1);
        List<String> allRow2s = splitByNumber(accountNumberRows.row2);
        List<String> allRow3s = splitByNumber(accountNumberRows.row3);

        String number = IntStream.range(0, allRow1s.size())
                .mapToObj(i -> new LCDNumber(allRow1s.get(i), allRow2s.get(i), allRow3s.get(i)))
                .map(LCDNumber::toDigit)
                .map(String::valueOf)
                .collect(joining());
        return new AccountNumber(number);
    }

    private List<String> splitByNumber(String line) {
        return IntStream.iterate(0, i -> i < line.length(), i -> i + DIGIT_SIZE)
                .mapToObj(i -> line.substring(i, i + DIGIT_SIZE))
                .collect(toList());
    }
}
