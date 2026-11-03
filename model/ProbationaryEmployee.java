package model;

public class ProbationaryEmployee extends Employee {

    private double riceSubsidy;

    public ProbationaryEmployee(
            String employeeId,
            String firstName,
            String lastName,
            String position,
            double basicSalary,
            double hourlyRate,
            double riceSubsidy) {

        super(employeeId, firstName, lastName,
              position, basicSalary, hourlyRate);

        this.riceSubsidy = riceSubsidy;
    }

    @Override
    public double getGrossSalary() {
        return basicSalary;
    }

    @Override
    public double getBenefits() {
        return riceSubsidy;
    }

    @Override
    public double getDeductions() {
        return 0;
    }

    @Override
    public double getNetSalary() {
        return getGrossSalary()
                + getBenefits()
                - getDeductions();
    }
}