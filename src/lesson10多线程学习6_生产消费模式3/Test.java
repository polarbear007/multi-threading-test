package lesson10���߳�ѧϰ6_��������ģʽ3;

import java.util.Vector;

// Ϊ�˼򵥣���������ֻ����һ�ֲ�Ʒ�����ǰ���

public class Test {
	public static void main(String[] args) {
		System.out.println("����ʼ��");
		
		// �ȴ���һ�����ϣ�������Ų�Ʒ����ΪҪʹ�ö��̣߳�����ʹ�� Vector ���ϣ��̰߳�ȫ��
		Vector<Product> v = new Vector<Product>();

		// ����һ���߳�������������
		Make m = new Make(v);
		Thread t1 = new Thread(m, "��ʦ��");
		Thread t4 = new Thread(m, "��ʦ��");

		// ����2���߳�����������
		Sell s = new Sell(v);
		Thread t2 = new Thread(s, "����1");
		Thread t3 = new Thread(s, "����2");
		
		//�����߳�
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}
}
