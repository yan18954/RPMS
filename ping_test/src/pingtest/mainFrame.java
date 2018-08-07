package pingtest;

import java.io.IOException;
import java.util.Timer;

public class mainFrame {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("system start!");
		MyTimerTask myTask = new MyTimerTask();
		myTask.setup();
		Timer timer = new Timer(); 
		timer.schedule(new MyTimerTask(), 0, 3000);
	}
}
