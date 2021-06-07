package org.example.testing.exceptions;

import org.assertj.core.api.Assertions;
import org.example.testing.salaryCalculator.Employee;
import org.example.testing.salaryCalculator.TaskManagementSystem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SalaryCalculatorServiceTest {

    @Mock TaskManagementSystem taskManagementSystem;

    @Test
    public void shouldThrowForNoLongerWorkingEmployee() {
        //give
        SalaryCalculatorService salaryCalculatorService = new SalaryCalculatorService(taskManagementSystem);
        Employee ted = new Employee("Ted", BigDecimal.ZERO);

        Mockito.when(taskManagementSystem.countFinishedTasksForEmployee(ted)).thenThrow(new EmployeeNoLongerWorkingException());

        //when, then
        Assertions.assertThatThrownBy(() -> salaryCalculatorService.calculateSalary(ted))
                .isInstanceOf(SalaryCalculationFailedException.class)
                .hasCauseInstanceOf(EmployeeNoLongerWorkingException.class)
                .hasMessage("Could not calculate salary. Reason: Employee is no longer hired");
    }

    @Test
    public void shouldThrowForEmployeeNotInDb() {
        //give
        SalaryCalculatorService salaryCalculatorService = new SalaryCalculatorService(taskManagementSystem);
        Employee ted = new Employee("Ted", BigDecimal.ZERO);

        Mockito.when(taskManagementSystem.countFinishedTasksForEmployee(ted)).thenThrow(new EmployeeNotFoundException());

        //when, then
        Assertions.assertThatThrownBy(() -> salaryCalculatorService.calculateSalary(ted))
                .isInstanceOf(SalaryCalculationFailedException.class)
                .hasCauseInstanceOf(EmployeeNotFoundException .class)
                .hasMessage("Could not calculate salary. Reason: Employee not found in database");
    }
}