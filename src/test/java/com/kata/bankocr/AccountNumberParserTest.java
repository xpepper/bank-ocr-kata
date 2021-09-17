package com.kata.bankocr;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountNumberParserTest {
    @Test
    void parse_a_single_digit_account_number() {
        AccountNumberRow one = new AccountNumberRow(
                "   ",
                "  |",
                "  |");

        String accountNumber = new AccountNumberParser().parse(one);
        assertThat(accountNumber).isEqualTo("1");
    }

    @Test
    void parse_a_two_digits_account_number() {
        AccountNumberRow one = new AccountNumberRow(
                "    _ ",
                "  | _|",
                "  ||_ ");

        String accountNumber = new AccountNumberParser().parse(one);
        assertThat(accountNumber).isEqualTo("12");
    }
}