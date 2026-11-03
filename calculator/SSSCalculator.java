package calculator;

import model.Employee;

public class SSSCalculator implements PayrollCalculation {

    @Override
    public double calculate(Employee employee) {

        double basicSalary = employee.getBasicSalary();

        double[] thresholds = {
            19750, 20250, 20750, 21250, 21750,
            22250, 22750, 23250, 23750, 24250
        };

        double[] deductions = {
            900.00, 922.50, 945.00, 967.50, 990.00,
            1012.50, 1035.00, 1057.50, 1080.00, 1102.50
        };

        for (int i = 0; i < thresholds.length; i++) {
            if (basicSalary >= thresholds[i]
                    && (i == thresholds.length - 1
                    || basicSalary < thresholds[i + 1])) {
                return deductions[i];
            }
        }

        return 1125.00;
    }
}