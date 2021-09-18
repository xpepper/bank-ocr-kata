package com.kata.bankocr;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = Main.class.getClassLoader().getResource("testFile").getPath();

        BankOCR bankOCR = new BankOCR(new FileLineReader(filePath), new AccountNumberParser(), new ReportWriter() {
            @Override public void writeFor(List<AccountNumber> accountNumbers) {
                throw new UnsupportedOperationException("TODO");
            }
        });
        System.out.println("account numbers = " + bankOCR.parseAccountNumbers());
    }

}
