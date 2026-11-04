package service;

import dao.UserDAO;
import model.UserAccount;

public class AuthenticationService {

    private UserDAO userDAO;

    public AuthenticationService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserAccount login(
            String username,
            String password) {

        for (UserAccount user :
                userDAO.getAllUsers()) {

            if (user.getUsername().equals(username)
                    &&
                    user.getPassword().equals(password)) {

                return user;
            }
        }

        return null;
    }
}