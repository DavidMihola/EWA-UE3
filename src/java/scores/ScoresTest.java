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
        for (Score s : scores)
            System.out.println(s);
    }
}
