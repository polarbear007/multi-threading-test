package lesson10多线程学习4_同步机制带来的死锁问题1;

public class Test {
	public static void main(String[] args) {
		MyThread mt1 = new MyThread();
		MyThread mt2 = new MyThread();
		
		mt1.start();
		mt2.start();
	}
}
