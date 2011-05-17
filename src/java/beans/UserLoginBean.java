/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author david
 */
@ManagedBean
@RequestScoped
public class UserLoginBean {

    @ManagedProperty(value = "#{userDataBaseBean}")
    private UserDataBaseBean userDataBaseBean;
    @ManagedProperty(value = "#{userSessionBean}")
    private UserSessionBean userSessionBean;
    private String username;
    private String password;

    /** Creates a new instance of UserLoginBean */
    public UserLoginBean() {
    }

    public UserDataBaseBean getUserDataBaseBean() {
        return this.userDataBaseBean;
    }

    public void setUserDataBaseBean(UserDataBaseBean userDataBaseBean) {
        this.userDataBaseBean = userDataBaseBean;
    }

    public UserSessionBean getUserSessionBean() {
        return this.userSessionBean;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        if (userDataBaseBean.loginUser(username, password)) {
            userSessionBean.setUsername(username);
            userSessionBean.setUser(userDataBaseBean.getUser(username));
        }
        return ("/login.xhtml");
    }

    public String logout() {
        userSessionBean.setUsername(null);
        return ("/login.xhtml");
    }
}
