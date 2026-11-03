package model;

public abstract class Employee {

    protected String employeeId;
    protected String firstName;
    protected String lastName;
    protected String position;
    protected double basicSalary;
    protected double hourlyRate;

    public Employee(
            String employeeId,
            String firstName,
            String lastName,
            String position,
            double basicSalary,
            double hourlyRate) {

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.basicSalary = basicSalary;
        this.hourlyRate = hourlyRate;
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