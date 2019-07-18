package lesson13���߳�ѧϰ����_volatile;

class TicketSell implements Runnable{
	// ��һ������ʹ�� volatile ���Σ���ô���Ա�֤a�߳��жԸñ����޸��Ժ� b�߳��п��Զ�ȡ���޸ĺ��ֵ��Ҳ����˵ a�̵߳��޸Ķ�b�߳��ǿɼ��ġ�
	// ��������������У�ʹ�� volatile ��������������ظ������ ����Ʊ�����⡣  ------->   ��Ϊvolatile ֻ��֤�˿ɼ��ԣ�ȴ����֤ԭ���ԡ�
	//  ��   ticket-- �������������ԭ���Բ�������Ȼ a�߳�һ�޸ģ� b�߳̾������϶�ȡ���޸ĺ��ֵ������û���á���Ϊ ticket-- ʵ���Ͽ��Էֽ��������
	//   	1  �����ڴ��ж�ȡ����ticket��ֵ
	//   	2  Ȼ���� ticket ֵ��1
	//   	3 �����µ�ֵ���� ticket
	
	
//	���   ��ticket �Ĳ�����ԭ���Եģ�����˵    ticket = 2   �����ģ���ôʹ��     volatile �Ϳ��Խ���̼߳�İ�ȫ���⡣
	private volatile int tickets = 100;
	
	@Override
	public void run() {
		while(true) {
			if(tickets > 0) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "�����˵�" + (tickets--) + "��Ʊ");
			}else {
				break;
			}
		}
	}
	
}

public class VolatileTest {
	public static void main(String[] args) {
		TicketSell ts = new TicketSell();
		
		new Thread(ts, "����1").start();
		new Thread(ts, "����2").start();
		new Thread(ts, "����3").start();
		new Thread(ts, "����4").start();
	}
}
