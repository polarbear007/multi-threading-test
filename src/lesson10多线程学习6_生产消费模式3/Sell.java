package lesson10���߳�ѧϰ6_��������ģʽ3;

import java.util.Vector;

public class Sell implements Runnable {
	private Vector<Product> v;

	public Sell(Vector<Product> v) {
		this.v = v;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (v) {
				if (v.isEmpty()) {
					try {
						v.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (!v.isEmpty()) {
					v.remove(0);
					System.out.println(Thread.currentThread().getName() + "����ȥ��һ�����ӣ����ڻ���" + v.size() + "������");
					v.notifyAll();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}

	}

}
