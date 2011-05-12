/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import memory.MemoryGame;

/**
 *
 * @author david
 */
@ManagedBean(name="userSessionBean")
@SessionScoped
public class UserSessionBean {
    @ManagedProperty(value="#{userDataBaseBean}")
    private UserDataBaseBean userDataBaseBean;

    private boolean loggedIn;
    private MemoryGame game;
    private String username;
    private String password;

    /** Creates a new instance of UserSessionBean */
    public UserSessionBean() {
        game = new MemoryGame();
    }

    public UserDataBaseBean getUserDataBaseBean() {
        return this.userDataBaseBean;
    }

    public void setUserDataBaseBean(UserDataBaseBean userDataBaseBean) {
        this.userDataBaseBean = userDataBaseBean;
    }

    public boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
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
            this.loggedIn = true;
        }

        return("/login.xhtml");
    }

    public String getLoginStatus() {
        if (loggedIn) {
            return ("You are logged in as " + username);
        } else {
            return ("You are not logged in");
        }
    }
}
