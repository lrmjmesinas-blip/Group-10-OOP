package dao;

import java.io.*;
import java.util.*;

public class LeaveBalanceDAO {

    private final String filePath;

    public LeaveBalanceDAO(String filePath) {
        this.filePath = filePath;
    }

    public List<String[]> getAllLeaveBalances() {

        List<String[]> balances =
                new ArrayList<>();

        try (BufferedReader br =
                new BufferedReader(
                        new FileReader(filePath))) {

            String line;

            br.readLine();

            while ((line = br.readLine()) != null) {

                balances.add(line.split(","));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return balances;
    }
}