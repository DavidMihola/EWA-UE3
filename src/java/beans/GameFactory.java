/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import memory.*;

/**
 *
 * @author david
 */
@ManagedBean
@RequestScoped
public class GameFactory {

    @ManagedProperty(value = "#{userSessionBean}")
    private UserSessionBean userSessionBean;

    /** Creates a new instance of GameFactory */
    public GameFactory() {
    }

    public UserSessionBean getUserSessionBean() {
        return this.userSessionBean;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }

    public String createAndJoinGame() {
        MemoryGame game = new MemoryGame();
        String name = userSessionBean.getUsername();
        game.setPlayer1(new MemoryPlayer(name));
        game.setPlayer2(new MemoryPlayer("Gegner"));
        userSessionBean.setCurrentGame(game);
        return ("/table.xhtml");
    }
}
