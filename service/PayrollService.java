package service;

import calculator.PagibigCalculator;
import calculator.SSSCalculator;
import model.Employee;

public class PayrollService {

    private PagibigCalculator pagibigCalculator;
    private SSSCalculator sssCalculator;

    public PayrollService() {
        pagibigCalculator = new PagibigCalculator();
        sssCalculator = new SSSCalculator();
    }

    public double calculateTotalDeductions(Employee employee) {

        double pagibig =
                pagibigCalculator.calculate(employee);

        double sss =
                sssCalculator.calculate(employee);

        return pagibig + sss;
    }

    public double calculateNetSalary(Employee employee) {

        double grossSalary =
                employee.getGrossSalary();

        double benefits =
                employee.getBenefits();

        double deductions =
                calculateTotalDeductions(employee);

        return grossSalary + benefits - deductions;
    }
}