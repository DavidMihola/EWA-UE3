/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scores;

import java.util.List;

/**
 *
 * @author florian
 */
public class ScoresTest {
    public static void main(String[] args) throws Exception {
        FacebookConnector fbc = new FacebookConnectorImpl();
        System.out.println("Got access token: " + fbc.getAccessToken());
        List<Score> scores = fbc.getHighScoreList();
        System.out.println("Highscores:");
        for (Score s : scores)
            System.out.println("\t" + s);

        Score newScore = new Score(1, "OhManISuck");
        int place = fbc.publishHighScoreResult(newScore);

        System.out.println("Published " + newScore + ", placed " + place);
        scores = fbc.getHighScoreList();
        
        System.out.println("Higscores by \"OhManISuck\":");
        for (Score s : scores)
            if (s.getPlayerName().equals("OhManISuck"))
                System.out.println("\t" + s);
    }
}
