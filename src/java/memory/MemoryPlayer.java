/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memory;

/**
 *
 * @author david
 */
public class MemoryPlayer {
    private final String name;
    private int score;
    private int tries;


    public MemoryPlayer(String name) {
        this.name = name;
        score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getTries() {
        return tries;
    }

    public String getTime() {
        return("TODO");
    }

}
