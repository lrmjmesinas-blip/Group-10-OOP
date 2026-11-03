package model;

public class RegularEmployee extends Employee {

    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;

    public RegularEmployee(
            String employeeId,
            String firstName,
            String lastName,
            String position,
            double basicSalary,
            double hourlyRate,
            double riceSubsidy,
            double phoneAllowance,
            double clothingAllowance) {

        super(employeeId, firstName, lastName,
              position, basicSalary, hourlyRate);

        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
    }

    @Override
    public double getGrossSalary() {
        return basicSalary;
    }

    @Override
    public double getBenefits() {
        return riceSubsidy
                + phoneAllowance
                + clothingAllowance;
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