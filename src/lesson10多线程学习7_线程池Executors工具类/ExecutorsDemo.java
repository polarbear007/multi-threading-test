package lesson10多线程学习7_线程池Executors工具类;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*	工具类  Executors 创建线程池的几种常见方法：
 * 		1、  public static ExecutorService newCachedThreadPool()
 *   	2、 public static ExecutorService newFixedThreadPool()
 * 		3、 public static ExecutorService newSingleThreadExecutor()
 */	
public class ExecutorsDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 虽然线程池里面最重要的类是  ThreadPoolExecutor ，但是通过这个类构造线程池太麻烦了，我们只要会使用工具类
		// Executors 创建线程池就好了。
	
//		ExecutorService pool = Executors.newFixedThreadPool(5);
//		Future<?> f = pool.submit(new MyRunnable());
//		System.out.println(f.get());
//		pool.execute(new MyRunnable());
//		pool.execute(new MyRunnable());
//		pool.execute(new MyRunnable());
//		pool.execute(new MyRunnable());
//		pool.execute(new MyRunnable());
//		pool.execute(new MyRunnable());
//		pool.execute(new MyRunnable());
//		pool.execute(new MyRunnable());
//		pool.execute(new MyRunnable());
//		pool.execute(new MyRunnable());
//		pool.execute(new MyRunnable());
//		pool.execute(new MyRunnable());
//		pool.execute(new MyRunnable());
//		pool.execute(new MyRunnable());
//		pool.execute(new MyRunnable());
//		pool.execute(new MyRunnable());
//		
//		pool.shutdown();
		
		
		// Executors.newCachedThreadPool() ---->  源码里面其实是   corePoolSize 为0， maximumPoolSize 为 Integer.MAX_VALUE 的 ThreadPoolExecutor
//		理论上是可以放进非常多个线程哦！！！
		// 但是这个方法我们几乎不用，因为很可能会内存不够。 一般来说，我们用 newFixdThreadPool()   这个方法比较多。
		ExecutorService pool2 = Executors.newCachedThreadPool();
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		pool2.execute(new MyRunnable());
		
		pool2.shutdown();
		
	}
}
