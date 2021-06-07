package org.example.testing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.YearMonth;

import static org.assertj.core.api.Assertions.assertThat;

class MonthCalculatorParametrizedTest {
    private MonthCalculator monthCalculator = new MonthCalculator();

    @ParameterizedTest
    @ValueSource(strings = {"2001-01", "2001-03", "2001-05", "2001-07", "2001-08", "2001-10", "2001-12"})
    public void shouldReturn31Days(String month) {
        YearMonth yearMonth = YearMonth.parse(month);

        int dayCount = monthCalculator.getDayCount(yearMonth.getYear(), yearMonth.getMonthValue());

        assertThat(dayCount).isEqualTo(31);
    }

    //rekomandowane
    @ParameterizedTest
    @CsvSource({"2001, 04", "2001, 06", "2001, 9", "2001, 11"})
    public void shouldReturn30Days(int year, int month) {
        int dayCount = monthCalculator.getDayCount(year, month);

        assertThat(dayCount).isEqualTo(30);
    }
}
