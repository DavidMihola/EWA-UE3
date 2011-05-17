package memory;

import java.util.ArrayList;
import java.util.Collections;
import java.lang.StringBuilder;

// Ein MemoryBoard verwaltet eine Menge von Kartenpaaren:
// - vor dem Spiel fügt man Kartenpaare hinzu
// - durch wiederholte Aufrufe von tryCard kann man versuchsweise Karten aufdecken
// - wenn man zwei gleiche Karten aufdeckt, bleibe diese danach aufgedeckt
// - wenn man zwei verschiede Karten aufdeckt, werden diese zu Beginn des nächsten Zuges
//   wieder umgedreht (nextTurn())
// Das MemoryBoard interessiert sich allerdings nicht für Spieler oder deren Punktestände.
// Um diese zu verwalten wird eine weitere Klasse MemoryGame notwendig sein.
public class MemoryBoard<T> {

    private ArrayList<MemoryCard<T>> cards;
    private boolean started;
    private int trial1, trial2; // Maybe Int
    private MemoryBoardState state;
    private int remainingPairs;

    public MemoryBoard() {
        cards = new ArrayList<MemoryCard<T>>();
        started = false;
        remainingPairs = 0;
        trial1 = -1;
        trial2 = -1; // Nothing
    }

    public void addPair(T front, T back) {
        if (!started) {
            cards.add(new MemoryCard<T>(front, back));
            cards.add(new MemoryCard<T>(front, back));
        }
    }

    public void start() {
        //if (!started) {
        remainingPairs = cards.size() / 2;
        Collections.shuffle(cards);
        started = true;
        nextTurn();
        //}
    }

    public void restart() {
        for (MemoryCard card : cards) {
            card.hide();
        }
        start();
    }

    public MemoryBoardState tryCard(int index) {
        // Wenn man versucht, eine Karte aufzudecken, die schon aufgedeckt ist,
        // passiert gar nichts
        // Das verhindert insbesondere auch, dass man die gleiche Karte in einem
        // Zug zwei mal aufdeckt
        if (cards.get(index).isRevealed()) {
            return state;
        }

        // Andernfalls wird die gewählte Karte ist noch nicht auf jeden Fall aufgedeckt

        cards.get(index).reveal();

        // Wenn die gewählte Karte in diesem Zug in die erste ist,
        // wird sie aufgedeckt, aber sonst muss nichts gemacht werden.
        if (trial1 == -1) {
            trial1 = index;
            state = MemoryBoardState.UNFINISHED_TURN;
            // Wenn die gewählte Karte schon die zweite ist, wird sie auch aufgedeckt
            // und die beiden Karten müssen verglichen werden
        } else if (trial2 == -1) {
            trial2 = index;
            if (cards.get(trial1).getFront() == cards.get(trial2).getFront()) {
                remainingPairs -= 1;
                if (remainingPairs > 0) {
                    state = MemoryBoardState.PAIR_FOUND;
                } else {
                    state = MemoryBoardState.GAME_OVER;
                }
            } else {
                state = MemoryBoardState.NO_PAIR_FOUND;
            }
        }
        return state;
    }

    public void nextTurn() {
        if (state == MemoryBoardState.NO_PAIR_FOUND) {
            cards.get(trial1).hide();
            cards.get(trial2).hide();
        }
        trial1 = -1;
        trial2 = -1;
        state = MemoryBoardState.NEW_TURN;
    }

    public boolean turnFinished() {
        return ((state == MemoryBoardState.PAIR_FOUND) || (state == MemoryBoardState.NO_PAIR_FOUND));
    }

    public boolean gameOver() {
        return (state == MemoryBoardState.GAME_OVER);
    }

    public int getRemainingPairs() {
        return remainingPairs;
    }

    public MemoryBoardState getState() {
        return state;
    }

    // toString = (concat . map show) cards
    public ArrayList<MemoryCard<T>> getCards() {
        return cards;
    }

    public MemoryCard<T> getCard(int cardNr) {
        return cards.get(cardNr);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        int len = cards.size();

        for (int i = 0; i < len; i++) {
            MemoryCard card = cards.get(i);
            output.append("Card Nr. " + i);
            if (card.isRevealed()) {
                output.append(" shows " + card);
            } else {
                output.append(" is hidden");
            }
            output.append("\n");
        }
        output.append("Board state is: " + state + "\n");

        return output.toString();
    }
}
