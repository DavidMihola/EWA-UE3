/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import memory.*;

/**
 *
 * @author david
 */
@ManagedBean
@SessionScoped
public class MemoryGameBean {

    @ManagedProperty(value = "#{userSessionBean}")
    private UserSessionBean userSessionBean;
    private MemoryPlayer player1;
    private MemoryPlayer player2;

    /** Creates a new instance of MemoryGameBean */
    public MemoryGameBean() {
    }

    public UserSessionBean getUserSessionBean() {
        return this.userSessionBean;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }

    public void setPlayer1(MemoryPlayer player) {
        this.player1 = player;
    }

    public MemoryPlayer getPlayer1() {
        return player1;
    }

    public String getPlayer1Name() {
        return player1.getName();
    }

    public int getPlayer1Score() {
        return player1.getScore();
    }

    public int getPlayer1Tries() {
        return player1.getTries();
    }

    public String getPlayer1Time() {
        return player1.getTime();
    }

    public void setPlayer2(MemoryPlayer player) {
        this.player2 = player;
    }

    public MemoryPlayer getPlayer2() {
        return player2;
    }

    public String getPlayer2Name() {
        return player2.getName();
    }

    public int getPlayer2Score() {
        return player2.getScore();
    }

    public int getPlayer2Tries() {
        return player2.getTries();
    }

    public String getPlayer2Time() {
        return player2.getTime();
    }

    public String start() {
        this.player1 = new MemoryPlayer(userSessionBean.getUsername());
        this.player2 = new MemoryPlayer("Gegner");
        return ("/table.xhtml");
    }
}
