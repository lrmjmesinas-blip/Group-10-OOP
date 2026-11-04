package service;

import calculator.PagibigCalculator;
import calculator.SSSCalculator;
import calculator.PhilHealthCalculator;
import calculator.WithholdingTaxCalculator;

import model.Employee;
import model.Payslip;

public class PayrollService {

    private final PagibigCalculator pagibigCalculator;
    private final SSSCalculator sssCalculator;
    private final PhilHealthCalculator philHealthCalculator;
    private final WithholdingTaxCalculator withholdingTaxCalculator;

    public PayrollService() {
        pagibigCalculator = new PagibigCalculator();
        sssCalculator = new SSSCalculator();
        philHealthCalculator = new PhilHealthCalculator();
        withholdingTaxCalculator = new WithholdingTaxCalculator();
    }

    public double calculateBenefits(Employee employee) {
        return employee.getBenefits();
    }

    public double calculateSSS(Employee employee) {
        return sssCalculator.calculate(employee);
    }

    public double calculatePhilHealth(Employee employee) {
        return philHealthCalculator.calculate(employee);
    }

    public double calculatePagibig(Employee employee) {
        return pagibigCalculator.calculate(employee);
    }

    public double calculateWithholdingTax(Employee employee) {
        return withholdingTaxCalculator.calculate(employee);
    }

    public double calculateTotalDeductions(Employee employee) {

        return calculateSSS(employee)
                + calculatePhilHealth(employee)
                + calculatePagibig(employee)
                + calculateWithholdingTax(employee);
    }

    public double calculateNetSalary(Employee employee) {

        double grossSalary = employee.getGrossSalary();

        double benefits = calculateBenefits(employee);

        double deductions = calculateTotalDeductions(employee);

        return grossSalary + benefits - deductions;
    }

    public Payslip processPayroll(Employee employee) {

        double grossSalary = employee.getGrossSalary();

        double benefits = employee.getBenefits();

        double deductions = calculateTotalDeductions(employee);

        double netSalary =
                grossSalary + benefits - deductions;

        return new Payslip(
                employee,
                grossSalary,
                benefits,
                deductions,
                netSalary
        );
    }
}