package com.kata.bankocr;

public class Main {

    public static void main(String[] args) {
        String filePath = Main.class.getClassLoader().getResource("testFile").getPath();

        BankOCR bankOCR = new BankOCR(
                new FileLineReader(filePath),
                new AccountNumberParser(),
                new ReportWriter(lines -> {
                    throw new UnsupportedOperationException("TODO");
                })
        );
        System.out.println("account numbers = " + bankOCR.scanAccountNumbers());
    }

}
