package lesson10多线程学习8_Timer类;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo01 {
	public static void main(String[] args) {
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}, 1000, 1000);
	}
}
