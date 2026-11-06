package ui;

import dao.AttendanceDAO;
import dao.EmployeeDAO;
import dao.LeaveBalanceDAO;

import model.AttendanceRecord;
import model.Employee;
import model.Payslip;

import service.PayrollService;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    private String firstName;
    private String employeeId;

    private JTextArea outputArea;

    public Dashboard(
            String firstName,
            String employeeId) {

        this.firstName = firstName;
        this.employeeId = employeeId;

        initializeUI();
    }

    private void initializeUI() {

        setTitle("MotorPH Dashboard");

        setSize(700, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());

        JLabel welcomeLabel =
                new JLabel(
                        "Welcome "
                        + firstName
                        + " ("
                        + employeeId
                        + ")",
                        SwingConstants.CENTER);

        panel.add(
                welcomeLabel,
                BorderLayout.NORTH);

        outputArea =
                new JTextArea();

        outputArea.setEditable(false);

        panel.add(
                new JScrollPane(outputArea),
                BorderLayout.CENTER);

        JPanel buttonPanel =
                new JPanel();

        JButton payrollButton =
                new JButton(
                        "View Payroll");

        JButton attendanceButton =
                new JButton(
                        "View Attendance");

        JButton leaveButton =
                new JButton(
                        "View Leave Balance");

        JButton logoutButton =
                new JButton(
                        "Logout");

        buttonPanel.add(payrollButton);

        buttonPanel.add(attendanceButton);

        buttonPanel.add(leaveButton);

        buttonPanel.add(logoutButton);

        panel.add(
                buttonPanel,
                BorderLayout.SOUTH);

                payrollButton.addActionListener(e -> {

            EmployeeDAO employeeDAO =
                    new EmployeeDAO(
                            "data/EmployeeDetails.csv");

            Employee employee =
                    employeeDAO.findEmployeeById(
                            employeeId);

            PayrollService payrollService =
                    new PayrollService();

            Payslip payslip =
                    payrollService.processPayroll(
                            employee);

            outputArea.setText(
                    payslip.toString());
        });
    
            attendanceButton.addActionListener(e -> {

            AttendanceDAO attendanceDAO =
                    new AttendanceDAO(
                            "data/AttendanceRecord.csv");

            StringBuilder sb =
                    new StringBuilder();

            for (AttendanceRecord record :
                    attendanceDAO
                            .getAllAttendanceRecords()) {

                if (record.getEmployeeId()
                        .equals(employeeId)) {

                    sb.append(
                            record.getDate())
                            .append(" | ")
                            .append(record.getTimeIn())
                            .append(" | ")
                            .append(record.getTimeOut())
                            .append("\n");
                }
            }

            outputArea.setText(
                    sb.toString());
        });
    
            leaveButton.addActionListener(e -> {

            LeaveBalanceDAO leaveDAO =
                    new LeaveBalanceDAO(
                            "data/LeaveBalances.csv");

            StringBuilder sb =
                    new StringBuilder();

            for (String[] row :
                    leaveDAO.getAllLeaveBalances()) {

                if (row[0].equals(employeeId)) {

                    sb.append(
                            "Sick Leave: ")
                            .append(row[1])
                            .append("\n");

                    sb.append(
                            "Vacation Leave: ")
                            .append(row[2])
                            .append("\n");

                    sb.append(
                            "Birthday Leave: ")
                            .append(row[3]);
                }
            }

            outputArea.setText(
                    sb.toString());
        });

            logoutButton.addActionListener(e -> {

            dispose();

            new Login().setVisible(true);
        });

        add(panel);
    }
}