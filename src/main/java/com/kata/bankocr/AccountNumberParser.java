package com.kata.bankocr;

import java.util.List;
import java.util.stream.IntStream;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.toList;

public class AccountNumberParser {

    public String parse(AccountNumberRows accountNumberRows) {

        List<String> allRow1s = splitByNumber(accountNumberRows.row1);
        List<String> allRow2s = splitByNumber(accountNumberRows.row2);
        List<String> allRow3s = splitByNumber(accountNumberRows.row3);

        List<LCDNumber> lcdNumbers = IntStream.range(0, allRow1s.size())
                .mapToObj(i -> new LCDNumber(allRow1s.get(i), allRow2s.get(i), allRow3s.get(i)))
                .collect(toList());

        return lcdNumbers.stream()
                .map(LCDNumber::toDigit)
                .map(String::valueOf)
                .reduce("", (acc, each) -> acc + each);
    }

    private List<String> splitByNumber(String line) {
        return IntStream.iterate(0, i -> i < line.length(), i -> i + 3)
                .mapToObj(i -> valueOf(line.charAt(i)) + valueOf(line.charAt(i + 1)) + valueOf(line.charAt(i + 2)))
                .collect(toList());
    }
}
