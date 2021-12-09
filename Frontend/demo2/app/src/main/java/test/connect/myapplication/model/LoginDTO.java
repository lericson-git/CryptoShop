package test.connect.myapplication.model;

/**
 * This is a class used to login a user
 */
public class LoginDTO {
    /**
     * the username or email used to log a user in
     */
    private String usernameOrEmail;
    /**
     * the password of the LoginDTO you want to login
     */
    private String password;


    /**
     * get the username or email of a LoginDTO
     * @return the username or email of a LoginDTO
     */
    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    /**
     * set the username or email of a LoginDTO
     * @param usernameOrEmail the username or email of a LoginDTO to set
     */
    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    /**
     * get the hashed password of a LoginDTO
     * @return the hashed password of a LoginDTO
     */
    public String getPassword() {
        return password;
    }

    /**
     * set the hashed password of a LoginDTO
     * @param password the password of a LoginDTO to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
