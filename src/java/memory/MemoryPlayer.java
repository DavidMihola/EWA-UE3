/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memory;

import timer.Timer;

import scores.Score;

/**
 *
 * @author david
 */
public class MemoryPlayer {
    private final String name;
    private int pairs;
    private int tries;
    private Timer timer;
    private int place;

    public MemoryPlayer(String name) {
        this.name = name;
        pairs = 0;
        tries = 0;
        place = -1;
        timer = new Timer();
    }

    public String getName() {
        return name;
    }

    public int getPairs() {
        return pairs;
    }

    public int getTries() {
        return tries;
    }

    public String getTime() {
        long seconds = timer.getTime() / 1000;
        long minutes = seconds / 60;
        seconds %= 60; // remaining seconds
        return("" + minutes + ":" + seconds); // TODO?: so formatieren M:SS
    }

    public void incTries() {
        tries++;
    }

    public void increaseScore() {
        pairs++;
    }

    public void startTimer() {
        timer.reset();
        timer.go();
    }

    public void pauseTimer() {
        timer.pause();
    }

    public void resetTimer() {
        timer.reset();
    }
    
    public int getScoreResult() {
        return 300 - (((int) timer.getTime() / 1000) / pairs);
    }

    public Score getScore() {
        return new Score(getScoreResult(), name);
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public int getPlace() {
        return place;
    }

    public boolean getShowPlace() {
        return (place != -1);
    }
}
