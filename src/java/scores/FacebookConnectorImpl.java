/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scores;

import java.util.List;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author florian
 */
public class FacebookConnectorImpl implements FacebookConnector {

    final private static String APP_ID = "182396081803634";
    final private static String APP_SECRET = "b78130a706117c79d717dd0baa936e0a";
    final private String accessToken;

    public FacebookConnectorImpl() throws Exception {
        URL graph = new URL("https://graph.facebook.com/oauth/access_token?client_id="
                + APP_ID + "&client_secret=" + APP_SECRET
                + "&grant_type=client_credentials");
        BufferedReader in = new BufferedReader(new InputStreamReader(graph.openStream()));
        String line = in.readLine();
        if (line == null)
            throw new Exception("Could not retrieve access token!");
        accessToken = line.split("=", 2)[1];
    }

    public List<Score> getHighScoreList() throws Exception {
        return null;
    }

    public Integer publishHighScoreResult(Score score) throws Exception {
        return 1;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
