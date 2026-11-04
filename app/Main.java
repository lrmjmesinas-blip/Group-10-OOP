package app;

import dao.EmployeeDAO;
import model.Employee;
import model.Payslip;
import service.PayrollService;

public class Main {

    public static void main(String[] args) {

        EmployeeDAO employeeDAO =
                new EmployeeDAO(
                        "data/EmployeeDetails.csv"
                );

        PayrollService payrollService =
                new PayrollService();

        if (employeeDAO.getAllEmployees().isEmpty()) {

            System.out.println(
                    "No employees loaded."
            );

            return;
        }

        Employee employee =
                employeeDAO.getAllEmployees().get(0);

        Payslip payslip =
                payrollService.processPayroll(
                        employee
                );

        System.out.println(
                payslip
        );
    }
}