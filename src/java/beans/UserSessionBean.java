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

import javax.faces.event.ActionEvent;

/**
 *
 * @author david
 */
@ManagedBean(name = "userSessionBean")
@SessionScoped
public class UserSessionBean implements Serializable {

    private MemoryGame currentGame;
    private String username;
    private String backcardpath = "../img/card_background.png";

    private String indexString; /* ugly */

    /** Creates a new instance of UserSessionBean */
    public UserSessionBean() {
        currentGame = null;
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

    public void setCurrentGame(MemoryGame game) {
        this.currentGame = game;
    }

    public MemoryGame getCurrentGame() {
        return currentGame;
    }

    public String getBackcardpath() {
        return backcardpath;
    }

    /* ugly */
    public void setIndexString(ActionEvent event) {
        indexString = (String) event.getComponent().getAttributes().get("index");
    }
    public void tryCard() {
        currentGame.tryCardPlayer1(Integer.parseInt(indexString));
    }
    /* /ugly */
}