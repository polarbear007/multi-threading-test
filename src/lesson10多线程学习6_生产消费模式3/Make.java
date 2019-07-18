package lesson10���߳�ѧϰ6_��������ģʽ3;

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
					System.out.println(Thread.currentThread().getName() + "����1�����ӣ����ڻ���" + v.size() + "������");
				}else if (v.isEmpty()) {
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}

					for (int x = 0; x < 5; x++) {
						Product p = new Product("����", 2);
						v.add(p);
					}
					System.out.println("��Ϊ������");
					System.out.println(Thread.currentThread().getName() + "������5�����ӣ����ڻ���" + v.size() + "������");
				}
				
				
				v.notifyAll();
			}
		}
	}

}
