/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedProperty;

import java.io.Serializable;

/**
 *
 * @author florian
 */
@ManagedBean(name="userRegistrationBean")
@SessionScoped
public class UserRegistrationBean implements Serializable {
    @ManagedProperty(value="#{userDataBaseBean}")
    private UserDataBaseBean userDataBaseBean;
    
    private String username;
    private String password;
    private int stackSize;

    private boolean additionalData;
    private String firstname;
    private String lastname;
    private String dateOfBirth;

    private enum Sex {
        MALE, FEMALE
    }
    private Sex sex;

    public UserRegistrationBean() {
        additionalData = false;
    }

    public UserDataBaseBean getUserDataBaseBean() {
        return this.userDataBaseBean;
    }

    public void setUserDataBaseBean(UserDataBaseBean userDataBaseBean) {
        this.userDataBaseBean = userDataBaseBean;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setStackSize(int stackSize) {
        this.stackSize = stackSize;
    }

    public int getStackSize() {
        return stackSize;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setSex(String sex) {
        this.sex = sex.equals("m") ? Sex.MALE : Sex.FEMALE;
    }

    public String getSex() {
        return (sex == Sex.MALE) ? "m" : "f";
    }

    public boolean getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(boolean ad) {
        additionalData = ad;
    }

    public String register() {
        userDataBaseBean.addUser(username, password);
        return "/login.xhtml";
    }
}
