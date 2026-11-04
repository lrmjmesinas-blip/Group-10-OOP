package model;

public abstract class Employee {

    protected String employeeId;
    protected String firstName;
    protected String lastName;
    protected String position;
    protected String status;
    protected String immediateSupervisor;
    protected double basicSalary;
    protected double hourlyRate;
    protected double riceSubsidy;
    protected double phoneAllowance;
    protected double clothingAllowance;

    public Employee(
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

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.status = status;
        this.immediateSupervisor = immediateSupervisor;
        this.basicSalary = basicSalary;
        this.hourlyRate = hourlyRate;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public abstract double getGrossSalary();

    public abstract double getBenefits();

    public abstract double getDeductions();

    public abstract double getNetSalary();
}