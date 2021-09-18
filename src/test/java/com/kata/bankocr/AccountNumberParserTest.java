package com.kata.bankocr;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountNumberParserTest {
    @Test
    void parse_a_single_digit_account_number() {
        AccountNumberRows zero = new AccountNumberRows(
                " _ ",
                "| |",
                "|_|");

        AccountNumber accountNumber = new AccountNumberParser().parse(zero);
        assertThat(accountNumber).isEqualTo(new AccountNumber("0"));
    }

    @Test
    void parse_a_two_digits_account_number() {
        AccountNumberRows twelve = new AccountNumberRows(
                "    _ ",
                "  | _|",
                "  ||_ "
        );

        AccountNumber accountNumber = new AccountNumberParser().parse(twelve);
        assertThat(accountNumber).isEqualTo(new AccountNumber("12"));
    }

    @Test
    void parse_a_simple_account_number() {
        AccountNumberRows twelve = new AccountNumberRows(
                "    _  _     _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|",
                "  ||_  _|  | _||_|  ||_| _|"
        );

        AccountNumber accountNumber = new AccountNumberParser().parse(twelve);
        assertThat(accountNumber).isEqualTo(new AccountNumber("123456789"));
    }
}