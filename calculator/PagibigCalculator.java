package calculator;

import model.Employee;

public class PagibigCalculator implements PayrollCalculation {

    @Override
    public double calculate(Employee employee) {
        return 100.0;
    }
}