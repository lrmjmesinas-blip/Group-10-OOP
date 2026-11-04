package service;

import model.UserAccount;

public class AuthorizationService {

    public boolean isAdmin(UserAccount user) {
        return "Admin".equalsIgnoreCase(user.getRole());
    }

    public boolean isHR(UserAccount user) {
        return "HR".equalsIgnoreCase(user.getRole());
    }

    public boolean isEmployee(UserAccount user) {
        return "Employee".equalsIgnoreCase(user.getRole());
    }
}