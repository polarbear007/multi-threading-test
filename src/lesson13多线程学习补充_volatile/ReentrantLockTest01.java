package lesson13多线程学习补充_volatile;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyRunnable implements Runnable{
	//  注意: lock 对象一定要定义为一个共享的成员变量，最好还是静态常量，这样子才能保证每个线程都是使用同一把锁
	private static final Lock lock = new ReentrantLock(true);
	private int tickets = 1000;

	@Override
	public void run() {
		while(true) {
			//  注意，不要把 获取锁也放进 try 代码块中去，因为如果在获取的过程中出异常了，那么这时候没有拿到锁，却又要释放锁，就会抛问题
			//  注意， lock()  与    unlock()   必须 要成对出现！！！  跟 synchronized 不一样， Lock 锁必须由我们手动去获取，并且手动去释放。
			//  注意， lock()  与    unlock()    一般要配合 try-finally 使用，因为如果获得了锁以后出现异常了，jvm 并不会像 synchronized 同步一样自动帮我们释放锁的。
			lock.lock();
			try {
				if(tickets > 0) {
					System.out.println(Thread.currentThread().getName() + "卖出了第" + (tickets--) + "张票");
				}else {
					break;
				}
			}finally {
				lock.unlock();
			}
		}
		
	}
	
}

public class ReentrantLockTest01 {
	public static void main(String[] args) {
		MyRunnable mr = new MyRunnable();
		Thread t1 = new Thread(mr, "窗口1");
		Thread t2 = new Thread(mr, "窗口2");
		Thread t3 = new Thread(mr, "窗口3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
