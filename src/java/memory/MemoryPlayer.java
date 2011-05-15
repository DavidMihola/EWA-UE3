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
    private int pairs;
    private int tries;


    public MemoryPlayer(String name) {
        this.name = name;
        pairs = 0;
        tries = 0;
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
        return("TODO");
    }

}
