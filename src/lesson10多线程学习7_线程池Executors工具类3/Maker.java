package lesson10���߳�ѧϰ7_�̳߳�Executors������3;

import java.util.ArrayList;

public class Maker implements Runnable {
	private ArrayList<Product> arr;
	private String threadName;
	
	public Maker(ArrayList<Product> arr, String threadName) {
		this.arr = arr;
		this.threadName = threadName;
	}
	@Override
	public void run() {
		Thread.currentThread().setName(threadName);
		while(true) {
			synchronized (arr) {
				if(arr.size() >= 20) {
					System.out.println("��Ʒ���̫�࣬��ͣ������");
					try {
						arr.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else if(arr.size() > 0) {
					arr.add(new Product());
					System.out.println(Thread.currentThread().getName() + ": ������һ����Ʒ��Ŀǰ��Ʒ������" + arr.size());
				}else if(arr.size() == 0) {
					System.out.println("��治�㣬׷����������");
					arr.add(new Product());
					arr.add(new Product());
					arr.add(new Product());
					System.out.println(Thread.currentThread().getName() + ": ������������Ʒ��Ŀǰ��Ʒ������" + arr.size());
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
