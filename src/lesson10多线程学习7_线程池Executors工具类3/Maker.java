package lesson10多线程学习7_线程池Executors工具类3;

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
					System.out.println("产品库存太多，暂停生产！");
					try {
						arr.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else if(arr.size() > 0) {
					arr.add(new Product());
					System.out.println(Thread.currentThread().getName() + ": 生产了一个产品，目前产品数量：" + arr.size());
				}else if(arr.size() == 0) {
					System.out.println("库存不足，追加生产！！");
					arr.add(new Product());
					arr.add(new Product());
					arr.add(new Product());
					System.out.println(Thread.currentThread().getName() + ": 生产了三个产品，目前产品数量：" + arr.size());
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
