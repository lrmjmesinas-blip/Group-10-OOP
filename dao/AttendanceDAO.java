package dao;

import model.AttendanceRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {

    private final String filePath;

    public AttendanceDAO(String filePath) {
        this.filePath = filePath;
    }

    public List<AttendanceRecord> getAllAttendanceRecords() {

        List<AttendanceRecord> records =
                new ArrayList<>();

        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader(filePath))) {

            String line;

            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                AttendanceRecord record =
                        new AttendanceRecord(
                                data[0],
                                data[1],
                                data[2],
                                data[3],
                                data[4]
                        );

                records.add(record);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return records;
    }
}