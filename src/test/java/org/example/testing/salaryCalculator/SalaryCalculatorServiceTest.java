package org.example.testing.salaryCalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

class SalaryCalculatorServiceTest {

    @Mock TaskManagementSystem taskManagementSystem;
    private SalaryCalculatorService salaryCalculatorService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        salaryCalculatorService = new SalaryCalculatorService(taskManagementSystem);
    }

    @Test
    public void shouldHaveNoBonus() {
//        Employee employee = new Employee("Tomek", BigDecimal.valueOf(2000)); <- mniej rekomendowane podejście, lepiej tworzyć mock'i
        Employee employee = mock(Employee.class);
        when(employee.getBaseSalary()).thenReturn(BigDecimal.valueOf(2000));
        when(taskManagementSystem.countFinishedTasksForEmployee(employee)).thenReturn(9);

        BigDecimal salary = salaryCalculatorService.calculateSalary(employee);

        Assertions.assertThat(salary).isEqualTo(BigDecimal.valueOf(2000));
    }

    @ValueSource(ints = {10, 19})
    @ParameterizedTest
    public void shouldHave500Bonus(int finishedTasks) {
        Employee employee = new Employee("Tomek", BigDecimal.valueOf(2000));
        when(taskManagementSystem.countFinishedTasksForEmployee(employee)).thenReturn(finishedTasks);

        BigDecimal salary = salaryCalculatorService.calculateSalary(employee);

        Assertions.assertThat(salary).isEqualTo(BigDecimal.valueOf(2500));
    }

    @Test
    public void shouldHave1000Bonus() {
        Employee employee = new Employee("Tomek", BigDecimal.valueOf(2000));
        when(taskManagementSystem.countFinishedTasksForEmployee(employee)).thenReturn(20);

        BigDecimal salary = salaryCalculatorService.calculateSalary(employee);

        Assertions.assertThat(salary).isEqualTo(BigDecimal.valueOf(3000));
    }



}