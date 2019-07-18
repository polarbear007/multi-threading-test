package lesson13多线程学习补充_volatile;

/**
 * 在本例子中，我们的共享变量是 num, 在不同的线程中，对这个变量的操作都是简单的赋值操作。这个操作是原子性的，这个时候我们使用 volatile 修饰符的作用就会很明显了。
 * 
 * 如果我们不加修改符的话，那么出现在 a线程刚赋值 num = 1, 然后判断 num 是否为 0 的情况，虽然也会发生，但是发生的机率并不高。
 * 		---- 注意：这里发生的机率不高并不是说num 没有在其他线程被修改。更主要的原因是，别的线程对这个变量的修改，对本线程是不可见的。
 * 					实际上，别的线程很可能已经把 num 改成了0， 但是还没有同步到主内存中去而已
 * 
 * 如果我们加了 volatile 修饰符的话，那么打印的频率就大大提高了。
 * 		----- 注意： 发生变化的原因并不是因为 volatile 修饰符起到了锁的作用，而是 b 线程对 num 变量的修改变得可见了。 也就是说， b 线程一修改， a 线程立马就能看到了。
 * 					具体为什么会这样，暂时就不深入了。
 * 
 * ------>    这里，我们只要记住一点： volatile 可以保证不同线程间修改的可见性。   （当然，我并没有见过 volatile 的实际应用例子）
 */

class GetNum implements Runnable{
	private static volatile int num;
//	private static  int num;
	private boolean flag;
	public GetNum(boolean flag) {
		this.flag = flag;
	}
	@Override
	public void run() {
		while(true) {
			if(flag) {
				num = 1;
				if(num == 0) {
					System.out.println(Thread.currentThread().getName() + ": " + num);
				}
			}else {
				num = 0;
				
				if(num == 1) {
					System.out.println(Thread.currentThread().getName() + ": " + num);
				}
			}
		}
	}
}


public class VolatileTest01 {
	public static void main(String[] args) {
		new Thread(new GetNum(true), "true").start();
		new Thread(new GetNum(false), "false").start();
	}
}
