package model;

public class Payslip {

    private Employee employee;
    private double grossSalary;
    private double benefits;
    private double deductions;
    private double netSalary;

    public Payslip(Employee employee,
                   double grossSalary,
                   double benefits,
                   double deductions,
                   double netSalary) {

        this.employee = employee;
        this.grossSalary = grossSalary;
        this.benefits = benefits;
        this.deductions = deductions;
        this.netSalary = netSalary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public double getBenefits() {
        return benefits;
    }

    public double getDeductions() {
        return deductions;
    }

    public double getNetSalary() {
        return netSalary;
    }

    @Override
    public String toString() {
        return "Employee: "
                + employee.getFullName()
                + "\nGross Salary: "
                + grossSalary
                + "\nBenefits: "
                + benefits
                + "\nDeductions: "
                + deductions
                + "\nNet Salary: "
                + netSalary;
    }
}