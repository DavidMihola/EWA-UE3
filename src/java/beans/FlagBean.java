/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

import flags.FlagClient;
import javax.faces.model.SelectItem;
import java.util.List;
import java.util.ArrayList;
import at.ac.tuwien.big.flagservice.Flag;

/**
 *
 * @author david
 */
@ManagedBean
@ApplicationScoped
public class FlagBean {

    FlagClient flagClient;

    /** Creates a new instance of FlagBean */
    public FlagBean() {
        flagClient = new FlagClient();
    }

    public List<SelectItem> getGameSizes() {
        List<String> gameSizes = new ArrayList<String>();
        List<SelectItem> options;

        try {
            gameSizes = flagClient.getGameSizes();
        } catch (Exception e) {
            gameSizes.add("2x2");
            // use some kind of default values for continents...
        } finally {
            options = new ArrayList<SelectItem>();

            for (String gameSize : gameSizes) {
                options.add(new SelectItem(gameSize, gameSize));
            }
        }

        return options;
    }

    public List<SelectItem> getContinents() {
        List<String> continents = new ArrayList<String>();
        List<SelectItem> options;

        try {
            continents = flagClient.getContinents();
        } catch (Exception e) {
            continents.add("North America");
            // use some kind of default values for continents...
        } finally {
            options = new ArrayList<SelectItem>();

            for (String continent : continents) {
                options.add(new SelectItem(continent, continent));
            }
        }

        return options;
    }

    public List<Flag> getFlags(String continent, String gameSize) {
        List<Flag> flags = new ArrayList<Flag>();

        try {
            flags = flagClient.getFlags(continent, gameSize);
        } catch (Exception e) {
            // flags.add(new Flag...);
            // use some kind of default values for continents...
        }
        
        return flags;
    }
}
