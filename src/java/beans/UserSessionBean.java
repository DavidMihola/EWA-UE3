/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;

import memory.*;
import userDB.UserDataBaseUser;

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
    private UserDataBaseUser user;
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

    public UserDataBaseUser getUser() {
        return user;
    }

    public void setUser(UserDataBaseUser user) {
        this.user = user;
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
        indexString = event.getComponent().getAttributes().get("index").toString();
    }

    public void clickCard() {
        if (currentGame.gameOver()) {
            // was soll hier passieren?
        } else if (currentGame.turnFinished()) {
            currentGame.nextTurn();
        } else {
            currentGame.tryCard(Integer.parseInt(indexString));
        }
    }
    /* /ugly */
}
