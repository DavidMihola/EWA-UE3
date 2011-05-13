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

    private boolean additionalData;

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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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
