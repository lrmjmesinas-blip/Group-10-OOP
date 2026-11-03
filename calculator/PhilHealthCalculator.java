public class PhilHealthCalculator implements PayrollCalculation {

    @Override
    public double calculate(Employee employee) {
        double basicSalary = employee.getBasicSalary();
        double contributionRate = 0.035; // 3.5% contribution rate
        double contribution = basicSalary * contributionRate;

        // Ensure the contribution does not exceed the maximum limit
        double maxContribution = 900.0; // Maximum PhilHealth contribution
        if (contribution > maxContribution) {
            return maxContribution;
        }

        return contribution;
    }
}