package service;

import model.AttendanceRecord;

import java.util.ArrayList;
import java.util.List;

public class AttendanceService {

    private final List<AttendanceRecord> records;

    public AttendanceService() {
        records = new ArrayList<>();
    }

    public void recordAttendance(
            AttendanceRecord attendanceRecord) {

        records.add(attendanceRecord);
    }

    public List<AttendanceRecord> getAllRecords() {
        return records;
    }
}