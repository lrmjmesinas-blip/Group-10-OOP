package model;

public class ProbationaryEmployee extends Employee {

    public ProbationaryEmployee(
            String employeeId,
            String firstName,
            String lastName,
            String position,
            String status,
            String immediateSupervisor,
            double basicSalary,
            double hourlyRate,
            double riceSubsidy,
            double phoneAllowance,
            double clothingAllowance) {

        super(
                employeeId,
                firstName,
                lastName,
                position,
                status,
                immediateSupervisor,
                basicSalary,
                hourlyRate,
                riceSubsidy,
                phoneAllowance,
                clothingAllowance
        );
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
