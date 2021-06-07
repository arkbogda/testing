package org.example.testing;

import java.time.YearMonth;

public class MonthCalculator {

    int getDayCount(int year, int month) {
        return YearMonth.of(year, month).lengthOfMonth();
    }
}
