package lesson14多线程学习补充_ReentrantLock;

import java.util.Vector;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 希望使用 Vector 实现一个 BlockingQueue


class MyBlockingQueue<T> {
	private int maxLength;
	private  Vector<T> list = new Vector<>();
	private  final Lock lock = new ReentrantLock();
	private  final Condition putCondition = lock.newCondition();
	private  final Condition  takeCondition = lock.newCondition();
	
	public MyBlockingQueue(int maxLength) {
		this.maxLength = maxLength;
	}
	
	public void put(T t) {
		lock.lock();
		try {
			while(list.size() == maxLength) {
				try {
					//System.out.println("队列满了，等会儿再加！");
					putCondition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
				list.add(t);
			
		}finally {
			takeCondition.signal();
			lock.unlock();
		}
	}
	
	public T take() {
		lock.lock();
		try {
			while(list.isEmpty()) {
				try {
					//System.out.println("队列空了，等会儿再拿！");
					takeCondition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return list.remove(0);
			
		}finally {
			putCondition.signal();
			lock.unlock();
		}
	}
	
	
	
	@Override
	public String toString() {
		return list.toString();
	}
	
	public int size() {
		return list.size();
	}
}




class MyBlockingQueueTest implements Runnable{
	private MyBlockingQueue<String> queue;
	private boolean flag;
	
	public MyBlockingQueueTest(MyBlockingQueue<String> queue, boolean flag){
		this.queue = queue;
		this.flag = flag;
	}
	@Override
	public void run() {
		
		while(true) {
			if(flag) {
				queue.put("hehe");
				System.out.println(queue);
				
			}else {
				queue.take();
				System.out.println(queue);
				
			}
		}
		
		
	}
	
}

public class ReentrantLockTest02 {
	public static void main(String[] args) {
		MyBlockingQueue<String> queue = new MyBlockingQueue<String>(5);
		MyBlockingQueueTest mqt1 = new MyBlockingQueueTest(queue, true);
		MyBlockingQueueTest mqt2 = new MyBlockingQueueTest(queue, true);
		MyBlockingQueueTest mqt3 = new MyBlockingQueueTest(queue, true);
		MyBlockingQueueTest mqt4 = new MyBlockingQueueTest(queue, false);
		MyBlockingQueueTest mqt5 = new MyBlockingQueueTest(queue, false);
		MyBlockingQueueTest mqt6 = new MyBlockingQueueTest(queue, false);
		
		new Thread(mqt1).start();
		new Thread(mqt2).start();
		new Thread(mqt3).start();
		new Thread(mqt4).start();
		new Thread(mqt5).start();
		new Thread(mqt6).start();
	}
	
}
