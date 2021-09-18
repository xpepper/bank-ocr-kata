package com.kata.bankocr;

public class Main {

    public static void main(String[] args) {
        String filePath = Main.class.getClassLoader().getResource("testFile").getPath();
        String reportFilePath = "/tmp/report.txt";

        BankOCR bankOCR = new BankOCR(
                new FileLineReader(filePath),
                new AccountNumberParser(),
                new ReportWriter(new FileReportStorage(reportFilePath))
        );
        System.out.println("account numbers = " + bankOCR.scanAccountNumbers());
    }

}
