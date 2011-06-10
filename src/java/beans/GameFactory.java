/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import java.util.List;
import at.ac.tuwien.big.flagservice.Flag;


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

    @ManagedProperty(value = "#{flagBean}")
    private FlagBean flagBean;

    /** Creates a new instance of GameFactory */
    public GameFactory() {
    }

    public UserSessionBean getUserSessionBean() {
        return this.userSessionBean;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }

    public FlagBean getFlagBean() {
        return this.flagBean;
    }

    public void setFlagBean(FlagBean FlagBean) {
        this.flagBean = FlagBean;
    }
    public String createAndJoinGame() {
        String gameSize = userSessionBean.getUser().getGameSize();
        String continent = userSessionBean.getUser().getContinent();

        List<Flag> flags = flagBean.getFlags(continent, gameSize);
  
        MemoryGame game = new MemoryGame(gameSize, flags);

        String name = userSessionBean.getUsername();
        MemoryPlayer player1 = new MemoryPlayer(name);
        MemoryPlayer player2 = new MemoryPlayer("Gegner");
        game.setPlayer1(player1);
        game.setPlayer2(player2);
        game.start();
        userSessionBean.setCurrentGame(game);
        userSessionBean.setPlayer(player1);
        return ("/table.xhtml");
    }
}
