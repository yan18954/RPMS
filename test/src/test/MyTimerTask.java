package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask{
	
	SimpleDateFormat sdf = new SimpleDateFormat("ss");
	int i=1;
	public void run(){
		System.out.println(i);
		i++;
	}
}