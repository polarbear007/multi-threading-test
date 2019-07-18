package lesson10多线程学习7_线程池Executors工具类2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorsDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService pool = Executors.newFixedThreadPool(3);

		Future<Integer> f1 = pool.submit(new MyCallable(10));
		Future<Integer> f2 = pool.submit(new MyCallable(50));
		Future<Integer> f3 = pool.submit(new MyCallable(100));
		
		System.out.println(f1.get());
		System.out.println(f2.get());
		System.out.println(f3.get());
		
		pool.shutdown();
	}
}
