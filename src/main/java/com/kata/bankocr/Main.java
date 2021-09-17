package com.kata.bankocr;

public class Main {

    public static void main(String[] args) {
        String filePath = Main.class.getClassLoader().getResource("testFile").getPath();

        BankOCR bankOCR = new BankOCR(new FileLineReader(filePath), new AccountNumberParser());
        System.out.println("account numbers = " + bankOCR.parseAccountNumbers());
    }

}
