package lesson13���߳�ѧϰ����_volatile;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyRunnable implements Runnable{
	//  ע��: lock ����һ��Ҫ����Ϊһ������ĳ�Ա��������û��Ǿ�̬�����������Ӳ��ܱ�֤ÿ���̶߳���ʹ��ͬһ����
	private static final Lock lock = new ReentrantLock(true);
	private int tickets = 1000;

	@Override
	public void run() {
		while(true) {
			//  ע�⣬��Ҫ�� ��ȡ��Ҳ�Ž� try �������ȥ����Ϊ����ڻ�ȡ�Ĺ����г��쳣�ˣ���ô��ʱ��û���õ�����ȴ��Ҫ�ͷ������ͻ�������
			//  ע�⣬ lock()  ��    unlock()   ���� Ҫ�ɶԳ��֣�����  �� synchronized ��һ���� Lock �������������ֶ�ȥ��ȡ�������ֶ�ȥ�ͷš�
			//  ע�⣬ lock()  ��    unlock()    һ��Ҫ��� try-finally ʹ�ã���Ϊ�����������Ժ�����쳣�ˣ�jvm �������� synchronized ͬ��һ���Զ��������ͷ����ġ�
			lock.lock();
			try {
				if(tickets > 0) {
					System.out.println(Thread.currentThread().getName() + "�����˵�" + (tickets--) + "��Ʊ");
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
		Thread t1 = new Thread(mr, "����1");
		Thread t2 = new Thread(mr, "����2");
		Thread t3 = new Thread(mr, "����3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
