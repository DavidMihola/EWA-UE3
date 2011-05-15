/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;

import memory.MemoryGame;

/**
 *
 * @author david
 */
@ManagedBean(name = "userSessionBean")
@SessionScoped
public class UserSessionBean implements Serializable {

    private MemoryGame game;
    private String username;

    /** Creates a new instance of UserSessionBean */
    public UserSessionBean() {
        game = new MemoryGame();
        username = null;
    }

    public boolean getLoggedIn() {
        return (username != null);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginStatus() {
        if (getLoggedIn()) {
            return ("You are logged in as " + username);
        } else {
            return ("You are not logged in");
        }
    }
}
