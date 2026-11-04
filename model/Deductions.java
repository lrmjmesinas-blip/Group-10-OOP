package model;

public class Deductions {

    private double sss;
    private double philHealth;
    private double pagibig;
    private double withholdingTax;

    public Deductions(double sss,
                      double philHealth,
                      double pagibig,
                      double withholdingTax) {

        this.sss = sss;
        this.philHealth = philHealth;
        this.pagibig = pagibig;
        this.withholdingTax = withholdingTax;
    }

    public double getSSS() {
        return sss;
    }

    public double getPhilHealth() {
        return philHealth;
    }

    public double getPagibig() {
        return pagibig;
    }

    public double getWithholdingTax() {
        return withholdingTax;
    }

    public double getTotalDeductions() {
        return sss + philHealth + pagibig + withholdingTax;
    }
}