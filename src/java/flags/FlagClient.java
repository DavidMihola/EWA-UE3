/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package flags;

import net.java.dev.jaxb.array.StringArray;

import java.util.List;
//import java.util.ArrayList;

import at.ac.tuwien.big.flagservice.FlagServiceImplService;
import at.ac.tuwien.big.flagservice.FlagService;
import at.ac.tuwien.big.flagservice.FlagRequest;
import at.ac.tuwien.big.flagservice.FlagResponse;
import at.ac.tuwien.big.flagservice.Flag;

/**
 *
 * @author david
 */
public class FlagClient {
        public List<String> getContinents() throws Exception {
		FlagService port = new FlagServiceImplService().getFlagServiceImplPort();

		StringArray conts = port.getSupportedContinents();

                return conts.getItem();
	}

        public List<String> getGameSizes() throws Exception {
		FlagService port = new FlagServiceImplService().getFlagServiceImplPort();

		StringArray sizes = port.getSupportedGameSize();

                return sizes.getItem();
	}

        public List<Flag> getFlags(String continent, String gameSize) throws Exception {
            FlagRequest request = new FlagRequest();
            request.setContinent(continent);
            request.setGameSize(gameSize);

            FlagService port = new FlagServiceImplService().getFlagServiceImplPort();

            FlagResponse response = port.getFlags(request);

            return response.getFlags();
        }
}
