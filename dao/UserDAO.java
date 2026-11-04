package dao;

import model.UserAccount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private final String filePath;

    public UserDAO(String filePath) {
        this.filePath = filePath;
    }

    public List<UserAccount> getAllUsers() {

        List<UserAccount> users =
                new ArrayList<>();

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

                users.add(
                        new UserAccount(
                                data[1],   // username
                                data[4],   // firstname
                                data[0],   // employee id
                                data[13],  // role/position
                                data[2]    // password
                        )
                );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }
}