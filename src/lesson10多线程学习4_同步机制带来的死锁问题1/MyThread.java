package lesson10���߳�ѧϰ4_ͬ�����ƴ�������������1;

import java.util.Random;

public class MyThread extends Thread {
	public static final Object o1 = new Object();
	public static final Object o2 = new Object();

	@Override
	public void run() {
		while (true) {
			int x = new Random().nextInt(9);
			if (x % 2 == 0) {
				synchronized (o1) {
					System.out.println("����ż�����Ҹ����������ˣ�");
					synchronized (o2) {
						System.out.println("�Բ���!������");
					}
				}
			} else {
				synchronized (o2) {
					System.out.println("�����������Ҹ�ż�������ˣ�");
					synchronized (o1) {
						System.out.println("�Բ���!ż����");
					}
				}

			}
		}
	}
}
