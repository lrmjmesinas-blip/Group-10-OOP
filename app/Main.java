package app;

import dao.UserDAO;
import dao.EmployeeDAO;

import model.UserAccount;
import model.Employee;
import model.Payslip;

import service.AuthenticationService;
import service.PayrollService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UserDAO userDAO =
                new UserDAO(
                        "data/EmployeeDetails.csv");

        AuthenticationService auth =
                new AuthenticationService(
                        userDAO);

        System.out.println("=== MOTORPH LOGIN ===");

        System.out.print("Username: ");
        String username =
                scanner.nextLine();

        System.out.print("Password: ");
        String password =
                scanner.nextLine();

        UserAccount user =
                auth.login(
                        username,
                        password);

        if (user != null) {

            System.out.println(
                    "\nWelcome "
                    + user.getFirstName());

            EmployeeDAO employeeDAO =
                    new EmployeeDAO(
                            "data/EmployeeDetails.csv");

            Employee employee =
                    employeeDAO.findEmployeeById(
                            user.getEmployeeId());

            if (employee != null) {

                PayrollService payrollService =
                        new PayrollService();

                Payslip payslip =
                        payrollService.processPayroll(
                                employee);

                System.out.println(payslip);
            }

        } else {

            System.out.println(
                    "\nLogin Failed");
        }
    }
}