package lesson10多线程学习6_生产消费模式3;

import java.util.Vector;

public class Make implements Runnable {
	private Vector<Product> v;

	public Make(Vector<Product> v) {
		this.v = v;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (v) {
				if(v.size() >= 10){
					try {
						v.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else if(v.size() > 0) {
					v.add(new Product());
					System.out.println(Thread.currentThread().getName() + "做了1个包子，现在还有" + v.size() + "个包子");
				}else if (v.isEmpty()) {
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}

					for (int x = 0; x < 5; x++) {
						Product p = new Product("包子", 2);
						v.add(p);
					}
					System.out.println("因为库存紧张");
					System.out.println(Thread.currentThread().getName() + "又做了5个包子，现在还有" + v.size() + "个包子");
				}
				
				
				v.notifyAll();
			}
		}
	}

}
