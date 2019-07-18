package lesson10���߳�ѧϰ7_�̳߳�Executors������3;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args) {
		ArrayList<Product> arr = new ArrayList<Product>();
		
		ExecutorService pool = Executors.newFixedThreadPool(6);
		
		pool.execute(new Maker(arr, "������1"));
		pool.execute(new Maker(arr, "������2"));
		pool.execute(new Maker(arr, "������3"));
		
		pool.execute(new Seller(arr, "����1"));
		pool.execute(new Seller(arr, "����2"));
		pool.execute(new Seller(arr, "����3"));
	}
}
