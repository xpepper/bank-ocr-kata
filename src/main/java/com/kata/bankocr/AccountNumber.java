package com.kata.bankocr;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class AccountNumber {
    private final String number;

    public AccountNumber(String number) {
        this.number = number;
    }

    public boolean isValid() {
        List<Integer> digits = digits();
        int value = IntStream.range(0, digits.size()).map(i -> digits.get(i) * (2 + i)).sum();
        return value % 11 == 0;
    }

    private List<Integer> digits() {
        return number.chars()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .map(Integer::valueOf)
                .collect(toList());
    }
}
