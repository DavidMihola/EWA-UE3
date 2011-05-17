/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package memory;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author david
 */
public class MemoryGame {

    private MemoryPlayer player1;
    private MemoryPlayer player2;
    private MemoryBoard board;
    private final String backcardpath = "../img/card_background.png";
    private MemoryPlayer currentPlayer;

    public MemoryGame(int pairs) {
        board = new MemoryBoard<String>();

        ArrayList<String> allFlagPaths = new ArrayList<String>();

        allFlagPaths.add("../img/cards/at.jpg");
        allFlagPaths.add("../img/cards/cz.jpg");
        allFlagPaths.add("../img/cards/de.jpg");
        allFlagPaths.add("../img/cards/dk.jpg");
        allFlagPaths.add("../img/cards/es.jpg");
        allFlagPaths.add("../img/cards/fi.jpg");
        allFlagPaths.add("../img/cards/fr.jpg");
        allFlagPaths.add("../img/cards/gr.jpg");
        allFlagPaths.add("../img/cards/it.jpg");
        allFlagPaths.add("../img/cards/jp.jpg");
        allFlagPaths.add("../img/cards/kr.jpg");
        allFlagPaths.add("../img/cards/no.jpg");
        allFlagPaths.add("../img/cards/pt.jpg");
        allFlagPaths.add("../img/cards/ro.jpg");
        allFlagPaths.add("../img/cards/se.jpg");
        allFlagPaths.add("../img/cards/tr.jpg");
        allFlagPaths.add("../img/cards/uk.jpg");
        allFlagPaths.add("../img/cards/us.jpg");

        Collections.shuffle(allFlagPaths);

        for (int i = 1; i <= pairs; i++) {
            board.addPair(allFlagPaths.get(i), backcardpath);
        }
        
     }

    public void setPlayer1(MemoryPlayer player) {
        this.player1 = player;
    }

    public MemoryPlayer getPlayer1() {
        return player1;
    }

    public void setPlayer2(MemoryPlayer player) {
        this.player2 = player;
    }

    public MemoryPlayer getPlayer2() {
        return player2;
    }

    public void setBoard(MemoryBoard board) {
        this.board = board;
    }

    public MemoryBoard getBoard() {
        return board;
    }

    public void tryCard(int index) {
        board.tryCard(index);
        if (board.getState() != MemoryBoardState.UNFINISHED_TURN) {
            currentPlayer.incTries();
        }
    }

    public void start() {
        board.start();
        currentPlayer = player1;
    }
}
