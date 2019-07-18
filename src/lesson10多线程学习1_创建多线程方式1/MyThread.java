package lesson10多线程学习1_创建多线程方式1;

public class MyThread extends Thread {
	@Override
	public void run() {
		for(int x = 0; x < 100; x++) {
			System.out.println(getName() + ":" + x);
		}
	}
}
