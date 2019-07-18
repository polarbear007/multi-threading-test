package lesson10���߳�ѧϰ3_�̵߳İ�ȫ����;

public class TicketSelling implements Runnable {
	private int count = 100;

	@Override
	public void run() {
		// ԭ���Ĵ��룬û�м�ͬ�������
//		while (count > 0) {
//			count--;
//			System.out.println(Thread.currentThread().getName() + ": ����һ��Ʊ�� ���ڻ�ʣ" + count + "��Ʊ��");
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}

		// ע�ⲻҪ��while Ҳ�ŵ� synchronized ��������棬��Ϊ�����Ļ�����һ�������������е�Ʊ
//		synchronized (this) {
//			while (count > 0) {
//				count--;
//				System.out.println(Thread.currentThread().getName() + ": ����һ��Ʊ�� ���ڻ�ʣ" + count + "��Ʊ��");
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}

		// Ӧ�ð�while �ŵ����棬 �����Ǹ������ж�Ӧ�÷ŵ����������
		while (true) {
			synchronized (this.getClass()) {
				if(count > 0) {
					count--;
					System.out.println(Thread.currentThread().getName() + ": ����һ��Ʊ�� ���ڻ�ʣ" + count + "��Ʊ��");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					break;
				}
			}
		}
	}

}
