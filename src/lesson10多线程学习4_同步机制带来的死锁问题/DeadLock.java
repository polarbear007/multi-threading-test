package lesson10���߳�ѧϰ4_ͬ�����ƴ�������������;

public class DeadLock extends Thread {
	private int x;
	// �������һ��Ҫ�Ǿ�̬�ģ������������߳�ʹ�õ����Ż���ͬ������������(�������������Ǻ���Ҫ)
	// ��Ϊ���ַ�ʽ�������̣߳���Ҫ���� DeadLock ����������Ǿ�̬�Ļ����ǲ�ͬ�����ĳ�Ա�����ǲ���һ���ġ�
	private static final Object o1 = new Object();
	private static final Object o2 = new Object();
	
	public DeadLock(int x) {
		this.x = x;
	}

	// ���������⣬�ر�������ͬ��Ƕ���г��֡�   ������������ӣ� һ���߳���ż��,�������,o1����ռ�ã���һ�����������ߵ�����ģ�o2����ռ�á�     ��Ϊ��ͬ���������Ƕ�ף�
	//   ������Ҫ o2�����ܼ���ִ�У�ͬ����������Ҫo1�����ܼ���ִ�С�   �����̵߳ĳ���ͣ�����ˣ�����ȴ����޷����������ˡ�
	@Override
	public void run() {
		if (x % 2 == 0) {
			synchronized (o1) {
				System.out.println(getName() +":" + "����ż����");
				synchronized (o2) {
					System.out.println(getName() +":" +"��������ż�������������");
				}
			}
		} else if (x % 2 == 1) {
			synchronized (o2) {
				System.out.println(getName() +":" +"����������");
				synchronized (o1) {
					System.out.println(getName() +":" +"�����������������ż����");
				}
			}
			x++;
		}

	}
}
