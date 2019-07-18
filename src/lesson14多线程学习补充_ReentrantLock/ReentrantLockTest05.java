package lesson14多线程学习补充_ReentrantLock;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Product{
	
}

class Seller implements Runnable{
	private ArrayList<Product> list;
	private Lock lock;
	private Condition proCon;
	private Condition sellCon;
	
	public Seller(ArrayList<Product> list, Lock lock, Condition proCon, Condition sellCon) {
		this.list = list;
		this.lock = lock;
		this.proCon = proCon;
		this.sellCon = sellCon;
	}

	@Override
	public void run() {
		while(true) {
			lock.lock();
			try {
				if(list.isEmpty()) {
					try {
						System.out.println("库存不足，暂停出售");
						sellCon.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					list.remove(0);
					System.out.println(Thread.currentThread().getName() + "售出了一个商品，还剩" + list.size() + "个商品");
				}
				
				proCon.signal();
			}finally {
				lock.unlock();
			}
		}
		
	}
	
}

class Producer implements Runnable{
	private ArrayList<Product> list;
	private Lock lock;
	private Condition proCon;
	private Condition sellCon;
	
	public Producer(ArrayList<Product> list, Lock lock, Condition proCon, Condition sellCon) {
		this.list = list;
		this.lock = lock;
		this.proCon = proCon;
		this.sellCon = sellCon;
	}
	
	@Override
	public void run() {
		while(true) {
			lock.lock();
			try {
				if(list.size() == 10) {
					try {
						System.out.println("库存满了，暂停生产");
						proCon.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					list.add(new Product());
					System.out.println(Thread.currentThread().getName() + "生产了一个，现在有" + list.size() + "个商品");
				}
				
				
				sellCon.signal();
			}finally {
				lock.unlock();
			}
		}
		
	}
	
}

public class ReentrantLockTest05 {
	public static void main(String[] args) {
		ArrayList<Product> list = new ArrayList<>();
		Lock lock = new ReentrantLock();
		Condition proCon = lock.newCondition();
		Condition sellCon = lock.newCondition();
		
		Seller s = new Seller(list, lock, proCon, sellCon);
		Producer p = new Producer(list, lock, proCon, sellCon);
		
		new Thread(s, "窗口1").start();
		new Thread(s, "窗口2").start();
		new Thread(s, "窗口3").start();
		new Thread(p, "工人1").start();
		new Thread(p, "工人2").start();
		new Thread(p, "工人3").start();
	}
}
