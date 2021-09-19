package com.kata.bankocr;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class AccountNumber {
    private final String number;

    public AccountNumber(String number) {
        this.number = number;
    }

    public boolean isValid() {
        return isLegible() && hasValidChecksum();
    }

    private boolean isLegible() {
        return !number.contains("?");
    }
    
    private boolean hasValidChecksum() {
        List<Integer> digits = digits();
        int value = IntStream.range(0, digits.size())
                .map(i -> digits.get(i) * (2 + i))
                .sum();
        return value % 11 == 0;
    }

    private List<Integer> digits() {
        return number.chars()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .map(Integer::valueOf)
                .collect(toList());
    }

    @Override public String toString() {
        return number;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AccountNumber that = (AccountNumber) o;

        return new EqualsBuilder().append(number, that.number).isEquals();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder(17, 37).append(number).toHashCode();
    }
}
