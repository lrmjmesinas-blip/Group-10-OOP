package app;

import dao.EmployeeDAO;
import model.Employee;

public class Main {

    public static void main(String[] args) {

        EmployeeDAO dao =
                new EmployeeDAO(
                        "data/EmployeeDetails.csv"
                );

        for (Employee employee :
                dao.getAllEmployees()) {

            System.out.println(
                    employee.getEmployeeId()
                            + " - "
                            + employee.getFullName()
            );
        }
    }
}