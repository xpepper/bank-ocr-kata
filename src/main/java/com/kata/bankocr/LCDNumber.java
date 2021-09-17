package com.kata.bankocr;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Map;

public class LCDNumber {
    private final String line1;
    private final String line2;
    private final String line3;

    private static final LCDNumber ONE = new LCDNumber(
            "   ",
            "  |",
            "  |");
    private static final LCDNumber TWO = new LCDNumber(
            " _ ",
            " _|",
            "|_ ");

    public LCDNumber(String line1, String line2, String line3) {
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
    }

    public Integer toDigit() {
        Map<LCDNumber, Integer> dictionary = Map.of(ONE, 1, TWO, 2);
        return dictionary.get(this);
    }

    @Override public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        LCDNumber lcdNumber = (LCDNumber) o;

        return new EqualsBuilder().append(line1, lcdNumber.line1).append(line2, lcdNumber.line2).append(line3, lcdNumber.line3).isEquals();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder(17, 37).append(line1).append(line2).append(line3).toHashCode();
    }
}
