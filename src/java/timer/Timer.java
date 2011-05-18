package timer;

import java.util.Date;
import java.lang.String;

public class Timer{
	private long sum; // milliseconds
	private Date startedAt;
	private boolean running;

	public Timer() {
		reset();
		go();
	}

        public void reset() {
            sum = 0;
            running = false;
        }

	public void go() {
		if (! running) {
			startedAt = new Date();
			running = true;
		}
	}

	public void pause() {
		if (running) {
			Date now = new Date();
			sum += (now.getTime() - startedAt.getTime());
			running = false;
		}
	}

	public long getTime() {
		if (! running) {
			return sum;
		} else {
			Date now = new Date();
			long last = now.getTime() - startedAt.getTime();
			return sum + last;
		}
	}
}
