package lesson10���߳�ѧϰ6_��������ģʽ2;

// ʹ�������ڲ�������ٴ��������ࡣ
//  ���ң�ͬ����������д��Student�����档  ֻҪ����߳��޸ĵ����ݣ���ͬһ������ס�����ˡ�(��Ȼ��������д�ǲ�̫�õġ���Ϊѧ�����������ͬ���������о��ͺ����)

public class Test {
	public static void main(String[] args) {
		Student s  = new Student();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				int x = 0;
				while(true) {
					s.setStudent(x);
					x++;
				}
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				while(true) {
					s.getStudent();
				}
			}
		};
		
		t1.start();
		t2.start();
	}
}
