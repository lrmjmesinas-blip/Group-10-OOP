package calculator;

import model.Employee;

public class PhilHealthCalculator implements PayrollCalculation {

    @Override
    public double calculate(Employee employee) {

        double salary = employee.getBasicSalary();

        double contribution = salary * 0.05;

        return contribution / 2;
    }
}