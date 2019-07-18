package lesson13多线程学习补充_volatile;

class TicketSell implements Runnable{
	// 当一个变量使用 volatile 修饰，那么可以保证a线程中对该变量修改以后， b线程中可以读取到修改后的值，也就是说 a线程的修改对b线程是可见的。
	// 但是在这个例子中，使用 volatile 并不能真正解决重复标或者 负数票的问题。  ------->   因为volatile 只保证了可见性，却不保证原子性。
	//  而   ticket-- 这个操作并不是原子性操作，虽然 a线程一修改， b线程就能马上读取到修改后的值，但是没有用。因为 ticket-- 实际上可以分解成三步：
	//   	1  从主内存中读取变量ticket的值
	//   	2  然后让 ticket 值加1
	//   	3 最后把新的值赋给 ticket
	
	
//	如果   对ticket 的操作是原子性的，比如说    ticket = 2   这样的，那么使用     volatile 就可以解决线程间的安全问题。
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
				System.out.println(Thread.currentThread().getName() + "卖出了第" + (tickets--) + "张票");
			}else {
				break;
			}
		}
	}
	
}

public class VolatileTest {
	public static void main(String[] args) {
		TicketSell ts = new TicketSell();
		
		new Thread(ts, "窗口1").start();
		new Thread(ts, "窗口2").start();
		new Thread(ts, "窗口3").start();
		new Thread(ts, "窗口4").start();
	}
}
