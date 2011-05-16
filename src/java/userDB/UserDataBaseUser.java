/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package userDB;

import java.util.Date;
/**
 *
 * @author florian
 */
public class UserDataBaseUser {

    private String username, password;
    private String firstname, lastname;
    private Date dateOfBirth;

    public UserDataBaseUser() {
    }

    public UserDataBaseUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isPassword(String password) {
        return this.password.equals(password);
    }

    public void setAdditionalData(String firstname, String lastname, Date dateOfBirth) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return firstname + " " + lastname;
    }
}
