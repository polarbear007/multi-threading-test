package lesson10���߳�ѧϰ2_�������̷߳�ʽ2;
// �������̵߳ķ�ʽ2��
/*		A��	����һ��Runnable �ӿڵ�ʵ����(MyRunnable)��������дrun() ����
 * 		B:	�ڲ������У����� MyRunnable���� ��ֻ��Ҫһ����
 * 		C:  ����Thread ��Ķ��󣬲���  MyRunnable������Ϊ�������ݸ�  Thread ������Ҫ�����̣߳��ʹ�������Thread����
 * 		D:	ͨ��   start() ���������̣߳�
 * 
 * ˼����	Ϊʲô���˷�ʽ1����ҪŪһ����ʽ2�أ�
 * 			��Ϊ��ʽ1����Ҫ�̳�Thread �࣬�����п���������Ҫ���߳����е��࣬�Ѿ��и����ˡ�JAVA�ǲ������ж�̳еġ�
 * 				���ң���ʽ2�����ʵ������������̹߳��ܵ���Ч���룬��������������˼�롣
 */


public class Test {
	public static void main(String[] args) {
		MyRunnable mr = new MyRunnable();
		
		Thread t1 = new Thread(mr);
		Thread t2 = new Thread(mr);
		
		t1.setName("С��");
		t2.setName("����");
		
		t1.start();
		t2.start();
	}
}
