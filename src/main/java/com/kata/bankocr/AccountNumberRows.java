package com.kata.bankocr;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class AccountNumberRows {

    public final String row1;
    public final String row2;
    public final String row3;

    public AccountNumberRows(String row1, String row2, String row3) {
        this.row1 = row1;
        this.row2 = row2;
        this.row3 = row3;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AccountNumberRows that = (AccountNumberRows) o;

        return new EqualsBuilder().append(row1, that.row1).append(row2, that.row2).append(row3, that.row3).isEquals();
    }

    @Override public int hashCode() {
        return new HashCodeBuilder(17, 37).append(row1).append(row2).append(row3).toHashCode();
    }
}
