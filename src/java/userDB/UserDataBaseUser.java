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
    private String gameSize;
    private String continent;
    private Date dateOfBirth;

    public UserDataBaseUser() {
    }

    public UserDataBaseUser(String username, String password, String gameSize, String continent) {
        this.username = username;
        this.password = password;
        this.gameSize = gameSize;
        this.continent = continent;
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

    public String getGameSize() {
        return gameSize;
    }

    public void setGameSize(String gameSize) {
        this.gameSize = gameSize;
    }

    public String getRealName() { // TODO: rename
        return firstname + " " + lastname + ", DOB: " + dateOfBirth;
    }

    public String getAsString() {
        return username + ", PW: " + password + ", SS: " + gameSize;
    }

    public String getContinent() {
        return continent;
    }

   public void setContinent(String continent) {
        this.continent = continent;
    }
}
