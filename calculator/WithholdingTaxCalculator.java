package calculator;

import model.Employee;

public class WithholdingTaxCalculator implements PayrollCalculation {

    @Override
    public double calculate(Employee employee) {

        double salary = employee.getBasicSalary();

        if (salary <= 20833) {
            return 0;
        }

        return (salary - 20833) * 0.20;
    }
}