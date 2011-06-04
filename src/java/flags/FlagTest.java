package flags;

import java.util.List;
//import java.util.ArrayList;

import at.ac.tuwien.big.flagservice.Flag;


public class FlagTest {
	public static void main(String[] args) throws Exception {
                List<String> conts = new FlagClient().getContinents();

		for(String cont : conts) {
			System.out.println(cont);
		}

                List<String> sizes = new FlagClient().getGameSizes();
                for(String size : sizes) {
			System.out.println(size);
		}

                List<Flag> flags = new FlagClient().getFlags(conts.get(0), sizes.get(0));
                for(Flag flag : flags) {
			System.out.println(flag.getCountry() + " --> " + flag.getUrl());
		}
	}


}