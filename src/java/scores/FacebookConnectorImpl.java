/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scores;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.json.JSONObject;
import org.json.JSONArray;

/**
 *
 * @author florian
 */
public class FacebookConnectorImpl implements FacebookConnector {

    final private static String APP_ID = "182396081803634";
    final private static String APP_SECRET = "b78130a706117c79d717dd0baa936e0a";
    final private String accessToken;
    final private static Pattern regex = Pattern.compile("Points: ([0-9]+); Name: (.*)");

    public FacebookConnectorImpl() throws Exception {
        URL graph = new URL("https://graph.facebook.com/oauth/access_token?client_id="
                + APP_ID + "&client_secret=" + APP_SECRET
                + "&grant_type=client_credentials");
        BufferedReader in = new BufferedReader(new InputStreamReader(graph.openStream()));
        
        String line = in.readLine();
        if (line == null) {
            throw new Exception("Could not retrieve access token!");
        }

        accessToken = line.split("=", 2)[1];
    }

    // list is sorted, HIGH to LOW
    @Override
    public List<Score> getHighScoreList() throws Exception {
        URL graph = new URL("https://graph.facebook.com/"
                + APP_ID + "/feed?"
                + "&access_token=" + accessToken);
        BufferedReader in = new BufferedReader(new InputStreamReader(graph.openStream()));

        String all = "";
        String line;
        while ((line = in.readLine()) != null) {
            all += line + "\n";
        }

        JSONObject json = new JSONObject(all);
        JSONArray ja = json.getJSONArray("data");

        ArrayList<Score> list = new ArrayList<Score>();
        for (int i = 0; i < ja.length(); i++) {
            JSONObject obj = ja.getJSONObject(i);

            if (!obj.has("message")) {
                continue;
            }

            String message = obj.getString("message");
            Matcher matcher = regex.matcher(message);
            if (!matcher.matches()) {
                continue;
            }

            int scoreResult = Integer.parseInt(matcher.group(1));
            String playerName = matcher.group(2);

            list.add(new Score(scoreResult, playerName));
        }

        Collections.sort(list, new ScoreComparator());
        return list;
    }

    @Override
    public Integer publishHighScoreResult(Score score) throws Exception {
        return 1;
    }

    @Override
    public String getAccessToken() {
        return accessToken;
    }
}
