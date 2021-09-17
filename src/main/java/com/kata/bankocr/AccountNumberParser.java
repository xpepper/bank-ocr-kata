package com.kata.bankocr;

import java.util.List;
import java.util.stream.IntStream;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.toList;

public class AccountNumberParser {

    public String parse(AccountNumberRow accountNumberRow) {

        List<String> line1 = splitByNumber(accountNumberRow.line1);
        List<String> line2 = splitByNumber(accountNumberRow.line2);
        List<String> line3 = splitByNumber(accountNumberRow.line3);

        List<LCDNumber> lcdNumbers = IntStream.range(0, line1.size())
                .mapToObj(i -> new LCDNumber(line1.get(i), line2.get(i), line3.get(i)))
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
