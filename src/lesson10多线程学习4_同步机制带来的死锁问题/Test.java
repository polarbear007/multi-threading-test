package lesson10���߳�ѧϰ4_ͬ�����ƴ�������������;

// ���������⣬ֻ�ܿ������ڱ�̵�ʱ��ע��ȥ���⡣

public class Test {
	public static void main(String[] args) {
		DeadLock dl1 = new DeadLock(1);
		DeadLock dl2 = new DeadLock(2);
		
		dl1.setName("�߳�1");
		dl2.setName("�߳�2");
		
		dl1.start();
		dl2.start();
	
	}
}
