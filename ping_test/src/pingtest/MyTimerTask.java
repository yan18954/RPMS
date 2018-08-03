package pingtest;

import java.io.IOException;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
	static myFrame frame = new myFrame();
	void setup() throws IOException {
		frame.setFrame();
		frame.readCfg();
		frame.readServerCfg();
	}
	public void run() {
		frame.reflash();
	}
	
}