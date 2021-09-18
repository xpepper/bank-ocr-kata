package com.kata.bankocr;

import java.util.List;

public interface ReportStorage {
    void save(List<String> lines);
}
