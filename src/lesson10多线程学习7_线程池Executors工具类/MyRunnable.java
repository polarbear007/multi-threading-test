package lesson10���߳�ѧϰ7_�̳߳�Executors������;

public class MyRunnable implements Runnable{
	private static int num = 0;
	@Override
	public void run() {
		synchronized(this.getClass()) {
			System.out.println(Thread.currentThread().getName() + "---" + num);
			num++;
		}
	}

}
