package lesson10多线程学习4_同步机制带来的死锁问题;

public class DeadLock extends Thread {
	private int x;
	// 这里的锁一定要是静态的，这样子两个线程使用的锁才会是同样的两把锁。(常量不常量不是很重要)
	// 因为这种方式创建多线程，需要造多个 DeadLock 对象，如果不是静态的话，那不同变量的成员变量是不会一样的。
	private static final Object o1 = new Object();
	private static final Object o2 = new Object();
	
	public DeadLock(int x) {
		this.x = x;
	}

	// 死锁的问题，特别容易在同步嵌套中出现。   比如下面的例子， 一个线程是偶数,走上面的,o1锁被占用；另一个是奇数，走的下面的，o2锁被占用。     因为有同步代码块有嵌套，
	//   上面需要 o2锁才能继续执行，同样，下面需要o1锁才能继续执行。   两个线程的程序都停下来了，互相等待。无法继续运行了。
	@Override
	public void run() {
		if (x % 2 == 0) {
			synchronized (o1) {
				System.out.println(getName() +":" + "我是偶数！");
				synchronized (o2) {
					System.out.println(getName() +":" +"我是排在偶数后面的奇数！");
				}
			}
		} else if (x % 2 == 1) {
			synchronized (o2) {
				System.out.println(getName() +":" +"我是奇数！");
				synchronized (o1) {
					System.out.println(getName() +":" +"我是排在奇数后面的偶数！");
				}
			}
			x++;
		}

	}
}
