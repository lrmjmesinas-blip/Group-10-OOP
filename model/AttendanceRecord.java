package model;

public class AttendanceRecord {

    private String employeeId;
    private String date;
    private String timeIn;
    private String timeOut;
    private String totalWorkedHours;

    public AttendanceRecord(
            String employeeId,
            String date,
            String timeIn,
            String timeOut,
            String totalWorkedHours) {

        this.employeeId = employeeId;
        this.date = date;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.totalWorkedHours = totalWorkedHours;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getDate() {
        return date;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public String getTotalWorkedHours() {
        return totalWorkedHours;
    }
}