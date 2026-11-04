package model;

public class UserAccount {

    private String username;
    private String firstName;
    private String employeeId;
    private String role;
    private String password;

    public UserAccount(
            String username,
            String firstName,
            String employeeId,
            String role,
            String password) {

        this.username = username;
        this.firstName = firstName;
        this.employeeId = employeeId;
        this.role = role;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

}