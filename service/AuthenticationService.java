package service;

import model.UserAccount;

public class AuthenticationService {

    public boolean authenticate(UserAccount user,
                                String username) {

        return user.getUsername()
                .equals(username);
    }
}