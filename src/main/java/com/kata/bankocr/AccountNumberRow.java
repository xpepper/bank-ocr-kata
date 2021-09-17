package com.kata.bankocr;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class AccountNumberRow {

    private final String line1;
    private final String line2;
    private final String line3;

    public AccountNumberRow(String line1, String line2, String line3) {
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AccountNumberRow that = (AccountNumberRow) o;

        return new EqualsBuilder().append(line1, that.line1).append(line2, that.line2).append(line3, that.line3).isEquals();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder(17, 37).append(line1).append(line2).append(line3).toHashCode();
    }
}
