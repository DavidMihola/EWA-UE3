/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package memory;

/**
 *
 * @author david
 */
public class MemoryGame {

    private MemoryPlayer player1;
    private MemoryPlayer player2;
    private MemoryBoard board;

    private final String backcardpath = "../img/card_background.png";

    public MemoryGame(int pairs) {
        board = new MemoryBoard<String>();
        // hier sollte man pairs mal ein Paar hinzufügen
        board.addPair("front1", "back");
        board.addPair("front2", "back");
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
}
