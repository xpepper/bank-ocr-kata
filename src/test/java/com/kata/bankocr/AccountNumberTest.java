package com.kata.bankocr;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountNumberTest {
    @Test
    void detect_a_valid_account_number() {
        assertThat(new AccountNumber("345882865").isValid()).isTrue();
        
        assertThat(new AccountNumber("123123123").isValid()).isFalse();
        assertThat(new AccountNumber("345?82865").isValid()).isFalse();
    }
}

