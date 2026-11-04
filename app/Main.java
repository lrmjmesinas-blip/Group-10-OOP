package app;

import dao.UserDAO;
import model.UserAccount;
import service.AuthenticationService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UserDAO userDAO =
                new UserDAO(
                        "data/EmployeeDetails.csv"
                );

        AuthenticationService auth =
                new AuthenticationService(
                        userDAO
                );

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
                        password
                );

        if (user != null) {

            System.out.println(
                    "\nWelcome "
                    + user.getFirstName());

            System.out.println(
                    "Role: "
                    + user.getRole());

            System.out.println("\nMENU");
            System.out.println("1. View Payroll");
            System.out.println("2. View Attendance");
            System.out.println("3. View Leave Balance");

        } else {

            System.out.println(
                    "\nLogin Failed");
        }
    }
}