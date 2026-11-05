package app;

import dao.EmployeeDAO;
import dao.UserDAO;
import dao.AttendanceDAO;
import dao.LeaveBalanceDAO;

import model.AttendanceRecord;
import model.Employee;
import model.Payslip;
import model.UserAccount;

import service.AuthenticationService;
import service.PayrollService;

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

        EmployeeDAO employeeDAO =
                new EmployeeDAO(
                        "data/EmployeeDetails.csv"
                );

        PayrollService payrollService =
                new PayrollService();

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

        if (user == null) {

            System.out.println(
                    "\nLogin Failed"
            );

            return;
        }

        System.out.println(
                "\nWelcome "
                        + user.getFirstName()
        );

        int choice;

        do {

            System.out.println("\n=== MOTORPH MENU ===");
            System.out.println("1. View Payroll");
            System.out.println("2. View Attendance");
            System.out.println("3. View Leave Balance");
            System.out.println("4. Logout");

            System.out.print("Enter choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    Employee employee =
                            employeeDAO.findEmployeeById(
                                    user.getEmployeeId()
                            );

                    if (employee != null) {

                        Payslip payslip =
                                payrollService.processPayroll(
                                        employee
                                );

                        System.out.println(
                                payslip
                        );

                    } else {

                        System.out.println(
                                "Employee record not found."
                        );
                    }

                    break;

                case 2:

    AttendanceDAO attendanceDAO =
            new AttendanceDAO(
                    "data/AttendanceRecord.csv"
            );

    System.out.println(
            "\n=== ATTENDANCE RECORDS ==="
    );

    for (AttendanceRecord record :
            attendanceDAO.getAllAttendanceRecords()) {

        if (record.getEmployeeId()
                .equals(user.getEmployeeId())) {

            System.out.println(
                    record.getDate()
                    + " | "
                    + record.getTimeIn()
                    + " | "
                    + record.getTimeOut()
                    + " | "
                    + record.getTotalWorkedHours()
            );
        }
    }

    break;

                case 3:

    LeaveBalanceDAO leaveDAO =
            new LeaveBalanceDAO(
                    "data/LeaveBalances.csv"
            );

    System.out.println(
            "\n=== LEAVE BALANCES ==="
    );

    for (String[] row :
            leaveDAO.getAllLeaveBalances()) {

        if (row[0].equals(
                user.getEmployeeId())) {

            System.out.println(
                    "Sick Leave: "
                    + row[1]);

            System.out.println(
                    "Vacation Leave: "
                    + row[2]);

            System.out.println(
                    "Birthday Leave: "
                    + row[3]);
        }
    }

    break;

                case 4:

                    System.out.println(
                            "\nLogged out."
                    );

                    break;

                default:

                    System.out.println(
                            "\nInvalid choice."
                    );
            }

        } while (choice != 4);

        scanner.close();
    }
}