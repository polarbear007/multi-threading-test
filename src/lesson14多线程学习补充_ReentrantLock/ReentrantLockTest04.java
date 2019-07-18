package lesson14多线程学习补充_ReentrantLock;

import java.util.Vector;

//  跟二一样，老是出错。 原因现在也闹不明白

class MyQueue<T> {
	private int maxLength;
	private Vector<T> list = new Vector<>();

	public MyQueue(int maxLength) {
		this.maxLength = maxLength;
	}

	public synchronized void put(T t) {
		if (list.size() == maxLength) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			list.add(t);

		}

		notifyAll();
	}

	public synchronized T take() {
		try {
			if(list.isEmpty()) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				return list.remove(0);
			}
			
			return null;
		}finally {
			notifyAll();
		}

	}

	@Override
	public String toString() {
		return list.toString();
	}
}

class MyQueueTest implements Runnable {
	private MyQueue<String> queue;
	private boolean flag;

	public MyQueueTest(MyQueue<String> queue, boolean flag) {
		this.queue = queue;
		this.flag = flag;
	}

	@Override
	public void run() {
		while (true) {
			if (flag) {
				queue.put("hehe");
				System.out.println(queue);
			} else {
				queue.take();
				System.out.println(queue);
			}
		}

	}

}

public class ReentrantLockTest04 {
	public static void main(String[] args) {
		MyQueue<String> queue = new MyQueue<String>(5);
		MyQueueTest mqt1 = new MyQueueTest(queue, true);
		MyQueueTest mqt2 = new MyQueueTest(queue, true);
		MyQueueTest mqt3 = new MyQueueTest(queue, true);
		MyQueueTest mqt4 = new MyQueueTest(queue, false);
		MyQueueTest mqt5 = new MyQueueTest(queue, false);
		MyQueueTest mqt6 = new MyQueueTest(queue, false);

		new Thread(mqt1).start();
		new Thread(mqt2).start();
		new Thread(mqt3).start();
		new Thread(mqt4).start();
		new Thread(mqt5).start();
		new Thread(mqt6).start();
	}
}
