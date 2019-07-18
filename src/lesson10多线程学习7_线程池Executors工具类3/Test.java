package lesson10多线程学习7_线程池Executors工具类3;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args) {
		ArrayList<Product> arr = new ArrayList<Product>();
		
		ExecutorService pool = Executors.newFixedThreadPool(6);
		
		pool.execute(new Maker(arr, "生产者1"));
		pool.execute(new Maker(arr, "生产者2"));
		pool.execute(new Maker(arr, "生产者3"));
		
		pool.execute(new Seller(arr, "窗口1"));
		pool.execute(new Seller(arr, "窗口2"));
		pool.execute(new Seller(arr, "窗口3"));
	}
}
