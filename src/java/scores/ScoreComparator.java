/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scores;

import java.util.Comparator;

/**
 *
 * @author florian
 */
public class ScoreComparator implements Comparator<Score> {

    // sort from HIGH to LOW
    @Override
    public int compare(Score a, Score b) {
        if (a.getScoreResult() > b.getScoreResult())
            return -1;
        else if (b.getScoreResult() > a.getScoreResult())
            return +1;
        else
            return 0;
    }
}
