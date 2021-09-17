package com.kata.bankocr;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Map;

public class LCDNumber {
    private final String row1;
    private final String row2;
    private final String row3;

    private static final LCDNumber ONE = new LCDNumber(
            "   ",
            "  |",
            "  |");
    private static final LCDNumber TWO = new LCDNumber(
            " _ ",
            " _|",
            "|_ ");
    private static final LCDNumber THREE = new LCDNumber(
            " _ ",
            " _|",
            " _|");

    private static final LCDNumber FOUR = new LCDNumber(
            "   ",
            "|_|",
            "  |");

    private static final LCDNumber FIVE = new LCDNumber(
            " _ ",
            "|_ ",
            " _|");
    private static final LCDNumber SIX = new LCDNumber(
            " _ ",
            "|_ ",
            "|_|");
    private static final LCDNumber SEVEN = new LCDNumber(
            " _ ",
            "  |",
            "  |");
    private static final LCDNumber EIGHT = new LCDNumber(
            " _ ",
            "|_|",
            "|_|");
    private static final LCDNumber NINE = new LCDNumber(
            " _ ",
            "|_|",
            " _|");
    private static final LCDNumber ZERO = new LCDNumber(
            " _ ",
            "| |",
            "|_|");

    public LCDNumber(String row1, String row2, String row3) {
        this.row1 = row1;
        this.row2 = row2;
        this.row3 = row3;
    }

    public Integer toDigit() {
        Map<LCDNumber, Integer> dictionary = Map.of(
                ONE, 1,
                TWO, 2,
                THREE, 3,
                FOUR, 4,
                FIVE, 5,
                SIX, 6,
                SEVEN, 7,
                EIGHT, 8,
                NINE, 9,
                ZERO, 0
        );
        return dictionary.get(this);
    }

    @Override public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        LCDNumber lcdNumber = (LCDNumber) o;

        return new EqualsBuilder().append(row1, lcdNumber.row1).append(row2, lcdNumber.row2).append(row3, lcdNumber.row3).isEquals();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder(17, 37).append(row1).append(row2).append(row3).toHashCode();
    }
}
