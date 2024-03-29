package lesson10多线程学习3_线程的安全问题;

// 这时就出现了问题:    被卖出去的票，比实际的票多得多得多。   经常有一张票被卖2次到3次。   有时还会出现负数票。
//  	这种问题被称为线程安全问题。

// 出现这种问题的原因是：
//		JAVA 的线程调度模式是抢占式调度，在同一个时间点，不同的线程只有一个线程能随机获得CPU的使用权
//		而CPU只能执行原子性操作（比如：a = a + 1 就不是原子性操作，因为他可以分解成很多步， 首先， 找到变量a的地址，然后把里面的值拿出来，加1，再把新的结果重新赋值给变量a或者说存入a的地址）
//      也就是说run()  方法里面如果不是一段不可分割的操作代码，那么可能要分很多次才能运行完。可能运行一点点，CPU的使用权就被其他线程拿走了。
//      那么如果多个线程共同操作一个变量，就很容易出现混乱。    比如在某个时间点，   票还有1张，然后线程1获得使用权，符合条件，进入循环。还没有运行 count--,这时换线程2获得使用权了，
// 		 那么线程2也进来了。同样，线程2也还没有运行  count--, 线程3又获得了使用权，这时候  count还是等于1， 符合条件，也进来了。只要进来了，如果没有其他因素影响，就一定会走完。
//		但是不管怎么走，其实总的票只有一张，却被卖了3次。最后显示票剩余 -2张。

//   为了避免多线程的安全问题，JAVA提供了同步机制。即，把一段代码标记成类似一个原子性操作。那么，某一个线程在执行这段代码的时候，只要还没有执行完，其他线程无法获得CPU的使用权。
//  	格式 ：
//			synchronized(任意对象名){需要同步的代码}

//   当然，虽然可以使用任意的对象名，但是如果不同线程要实现同步，那么这个对象名就必须要相同 。一般我们都是使用那个被操作类的对象。  即那么实现了Runnablef接口的实现类对象。在这里就是ts对象。
//   如果，我们使用的是方式1的那种多线程方式，那么就需要在操作类外（一般是测试类中）建一个统一的对象传给他。

public class Test {
	public static void main(String[] args) {
		TicketSelling  ts = new TicketSelling();
		
		// 假设我们有三个窗口同时卖票
		Thread t1 = new Thread(ts);
		Thread t2 = new Thread(ts);
		Thread t3 = new Thread(ts);
		
		t1.setName("窗口一");
		t2.setName("窗口二");
		t3.setName("窗口三");
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}
