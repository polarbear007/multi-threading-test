package lesson10���߳�ѧϰ1_�������̷߳�ʽ1;

// �������̵߳ķ���1��
/*
 *  	A:  ����һ�� Thread ������(����MyThread)������д run() ����
 *  	B:	���� MyThread �Ķ�����Ҫ�����߳̾ʹ�����������
 *  	C�� 	ͨ�������  start() ���������߳�
 * ע�⣺   
 * 		��Ȼ run() ��������Ĵ��Ŷ��߳����еĴ��룬�����������̣߳�����ʹ��    start() ������
 * 			�������  run() ������ֻ����ͨ�ķ������ã�û�ж��߳�����
 * 
 */


public class Test {
	public static void main(String[] args) {
		MyThread mt1 = new MyThread();
		MyThread mt2 =  new MyThread();
		
		mt1.setName("С��");
		mt2.setName("����");
		
		mt1.start();
		mt2.start();
	}
}
