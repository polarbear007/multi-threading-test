package lesson10多线程学习7_线程池Executors工具类;

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
