package lesson10多线程学习4_同步机制带来的死锁问题1;

import java.util.Random;

public class MyThread extends Thread {
	public static final Object o1 = new Object();
	public static final Object o2 = new Object();

	@Override
	public void run() {
		while (true) {
			int x = new Random().nextInt(9);
			if (x % 2 == 0) {
				synchronized (o1) {
					System.out.println("我是偶数，我跟奇数吵架了！");
					synchronized (o2) {
						System.out.println("对不起!奇数。");
					}
				}
			} else {
				synchronized (o2) {
					System.out.println("我是奇数，我跟偶数吵架了！");
					synchronized (o1) {
						System.out.println("对不起!偶数。");
					}
				}

			}
		}
	}
}
