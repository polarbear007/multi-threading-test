package lesson10多线程学习7_线程池Executors工具类3;

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
					System.out.println("库存不足，暂停出售 ！！！");
					try {
						arr.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else if(arr.size() > 0) {
					arr.remove(0);
					System.out.println(Thread.currentThread().getName() + ": 售出一个产品，目前产品数量：" + arr.size());
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
