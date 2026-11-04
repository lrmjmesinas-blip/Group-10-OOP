package app;

import dao.EmployeeDAO;
import model.Employee;
import service.PayrollService;

public class Main {

    public static void main(String[] args) {

        EmployeeDAO employeeDAO =
                new EmployeeDAO(
                        "data/EmployeeDetails.csv");

        PayrollService payrollService =
                new PayrollService();

        for (Employee employee :
                employeeDAO.getAllEmployees()) {

            System.out.println(
                    employee.getFullName());

            System.out.println(
                    "Net Salary: "
                    + payrollService
                        .calculateNetSalary(employee));

            System.out.println();
        }
    }
}