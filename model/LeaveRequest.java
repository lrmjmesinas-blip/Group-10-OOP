package model;

import java.time.LocalDate;

public class LeaveRequest {

    private String employeeId;
    private LocalDate leaveDate;
    private String leaveType;
    private String status;

    public LeaveRequest(String employeeId,
                        LocalDate leaveDate,
                        String leaveType) {

        this.employeeId = employeeId;
        this.leaveDate = leaveDate;
        this.leaveType = leaveType;
        this.status = "Pending";
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public LocalDate getLeaveDate() {
        return leaveDate;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public String getStatus() {
        return status;
    }

    public void approve() {
        status = "Approved";
    }

    public void reject() {
        status = "Rejected";
    }
}