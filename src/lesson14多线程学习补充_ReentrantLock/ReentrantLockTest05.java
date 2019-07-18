package lesson14���߳�ѧϰ����_ReentrantLock;

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
						System.out.println("��治�㣬��ͣ����");
						sellCon.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					list.remove(0);
					System.out.println(Thread.currentThread().getName() + "�۳���һ����Ʒ����ʣ" + list.size() + "����Ʒ");
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
						System.out.println("������ˣ���ͣ����");
						proCon.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					list.add(new Product());
					System.out.println(Thread.currentThread().getName() + "������һ����������" + list.size() + "����Ʒ");
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
		
		new Thread(s, "����1").start();
		new Thread(s, "����2").start();
		new Thread(s, "����3").start();
		new Thread(p, "����1").start();
		new Thread(p, "����2").start();
		new Thread(p, "����3").start();
	}
}
