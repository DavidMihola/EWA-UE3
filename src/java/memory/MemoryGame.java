/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package memory;

import java.util.List;
import java.util.ArrayList;

import java.util.Collections;
import java.lang.Integer;
import java.lang.NumberFormatException;
import at.ac.tuwien.big.flagservice.Flag;

/**
 *
 * @author david
 */
public class MemoryGame {

    private MemoryPlayer player1;
    private MemoryPlayer player2;
    private MemoryBoard<Flag> board;
    private final String backcardpath = null; //"../img/card_background.png";
    private MemoryPlayer currentPlayer;
    private String gameSize;
    private final int rows;
    private final int cols;
    private MemoryCard[][] cardMatrix;

    public MemoryGame(String gameSize, List<Flag> flags) {
        this.gameSize = gameSize;

        String[] sizes = this.gameSize.split("x");

        int tmpRows = 0;
        try {
            tmpRows = Integer.parseInt(sizes[0]);
        } catch (NumberFormatException e) {
        }
        rows = tmpRows;

        int tmpCols = 0;
        try {
            tmpCols = Integer.parseInt(sizes[1]);
        } catch (NumberFormatException e) {
        }
        cols = tmpCols;

        int pairs = (rows * cols) / 2;

        board = new MemoryBoard<Flag>();

        for (Flag flag : flags) {
            board.addPair(flag, null);

        }
    }

    public MemoryCard<String>[][] getRows() {
        return cardMatrix;
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
        if (board.turnFinished()) {
            currentPlayer.incTries();
            if (board.getState() == MemoryBoardState.PAIR_FOUND) {
                currentPlayer.increaseScore();
                board.nextTurn();
            } else if (board.getState() == MemoryBoardState.GAME_OVER) {
                currentPlayer.increaseScore();
                currentPlayer.pauseTimer();
            }
        }
    }

    public String getStrings() {
        ArrayList<MemoryCard<Flag>> cardList = board.getCards();

        String output = "Kartenliste:";

        output += cardList.size();

        for (MemoryCard<Flag> card : cardList) {
            output = output + card.getVisibleSide().getUrl();
        }

        return output;
    }

    public boolean turnFinished() {
        return board.turnFinished();
    }

    public boolean gameOver() {
        return board.gameOver();
    }

    public void nextTurn() {
        board.nextTurn();
        // currentPlayer = nächster Spieler;
    }

    public void start() {
        board.start();

        cardMatrix = new MemoryCard[rows][cols];
        int row = 0;
        int col = 0;

        ArrayList<MemoryCard<Flag>> cardList = board.getCards();

        for (MemoryCard<Flag> card : cardList) {
            cardMatrix[row][col] = card;
            col++;
            if (col >= cols) {
                row++;
                col = 0;
            }
        }

        currentPlayer = player1;
        currentPlayer.startTimer();
        player2.resetTimer(); // Gegner.Zeit soll 0:0 sein
    }

    public int getRemainingPairs() {
        return board.getRemainingPairs();
    }

    public int getCols() {
        return cols;
    }
}
