package lesson10���߳�ѧϰ7_�̳߳�Executors������3;

import java.util.ArrayList;

public class Seller implements Runnable {
	private ArrayList<Product> arr;
	private String threadName;

	public Seller(ArrayList<Product> arr, String threadName) {
		this.arr = arr;
		this.threadName = threadName;
	}

	@Override
	public void run() {
		Thread.currentThread().setName(threadName);
		while(true) {
			synchronized (arr) {
				if(arr.size() == 0) {
					System.out.println("��治�㣬��ͣ���� ������");
					try {
						arr.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else if(arr.size() > 0) {
					arr.remove(0);
					System.out.println(Thread.currentThread().getName() + ": �۳�һ����Ʒ��Ŀǰ��Ʒ������" + arr.size());
					arr.notifyAll();
				}
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
