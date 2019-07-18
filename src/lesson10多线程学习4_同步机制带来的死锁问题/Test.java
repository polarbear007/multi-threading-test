package lesson10多线程学习4_同步机制带来的死锁问题;

// 死锁的问题，只能靠我们在编程的时候注意去避免。

public class Test {
	public static void main(String[] args) {
		DeadLock dl1 = new DeadLock(1);
		DeadLock dl2 = new DeadLock(2);
		
		dl1.setName("线程1");
		dl2.setName("线程2");
		
		dl1.start();
		dl2.start();
	
	}
}
