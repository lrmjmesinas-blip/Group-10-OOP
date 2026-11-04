package dao;

import model.UserAccount;

import java.io.*;
import java.util.*;

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

                UserAccount user =
                        new UserAccount(
                                data[1],
                                data[2],
                                data[4],
                                data[0],
                                data[13]
                        );

                users.add(user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }
}