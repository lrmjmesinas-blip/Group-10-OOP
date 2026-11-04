package dao;

import model.Employee;
import model.ProbationaryEmployee;
import model.RegularEmployee;

import java.io.*;
import java.util.*;

public class EmployeeDAO {

    private final String filePath;

    public EmployeeDAO(String filePath) {
        this.filePath = filePath;
    }

    public List<Employee> getAllEmployees() {

        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader(filePath))) {

            String line;

            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length < 21) {
                    continue;
                }

                System.out.println(Arrays.toString(data));

                try {

                    Employee employee;

                    if (data[12].equalsIgnoreCase("Regular")) {

                        employee =
                                new RegularEmployee(
                                        data[0],
                                        data[4],
                                        data[3],
                                        data[13],
                                        data[12],
                                        data[14],
                                        Double.parseDouble(data[15]),
                                        Double.parseDouble(data[20]),
                                        Double.parseDouble(data[16]),
                                        Double.parseDouble(data[17]),
                                        Double.parseDouble(data[18])
                                );

                    } else {

                        employee =
                                new ProbationaryEmployee(
                                        data[0],
                                        data[4],
                                        data[3],
                                        data[13],
                                        data[12],
                                        data[14],
                                        Double.parseDouble(data[15]),
                                        Double.parseDouble(data[20]),
                                        Double.parseDouble(data[16]),
                                        Double.parseDouble(data[17]),
                                        Double.parseDouble(data[18])
                                );
                    }

                    employees.add(employee);

                } catch (NumberFormatException e) {

                    System.out.println(
                            "Skipped malformed record: "
                                    + data[0]);
                }
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        return employees;
    }
}