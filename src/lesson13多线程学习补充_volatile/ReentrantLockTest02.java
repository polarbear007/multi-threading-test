package lesson13���߳�ѧϰ����_volatile;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyBlockingQueue<T> {
	private int maxLength;
	private LinkedList<T> list = new LinkedList<>();
	private  final Lock lock = new ReentrantLock();
	private  final Condition putCondition = lock.newCondition();
	private  final Condition  takeCondition = lock.newCondition();
	
	public MyBlockingQueue(int maxLength) {
		this.maxLength = maxLength;
	}
	
	public void put(T t) {
		lock.lock();
		try {
			if(list.size() == maxLength) {
				try {
					System.out.println("�������ˣ��Ȼ���ټӣ�");
					putCondition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			list.addFirst(t);
			takeCondition.signalAll();
		}finally {
			lock.unlock();
		}
	}
	
	public T take() {
		lock.lock();
		try {
			if(list.isEmpty()) {
				try {
					System.out.println("���п��ˣ��Ȼ�����ã�");
					takeCondition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			putCondition.signalAll();
			return list.removeLast();
		}finally {
			lock.unlock();
		}
	}
	
	
	
	@Override
	public String toString() {
		return list.toString();
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
		
			if(flag) {
				for (int i = 0; i < 20; i++) {
					queue.put("hehe");
					System.out.println(queue);
				}
			}else {
				for (int i = 0; i < 20; i++) {
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
		MyBlockingQueueTest mqt2 = new MyBlockingQueueTest(queue, false);
		
		new Thread(mqt1).start();
		new Thread(mqt2).start();
	}
	
}
