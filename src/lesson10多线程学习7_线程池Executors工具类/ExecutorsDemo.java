package lesson10���߳�ѧϰ7_�̳߳�Executors������;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*	������  Executors �����̳߳صļ��ֳ���������
 * 		1��  public static ExecutorService newCachedThreadPool()
 *   	2�� public static ExecutorService newFixedThreadPool()
 * 		3�� public static ExecutorService newSingleThreadExecutor()
 */	
public class ExecutorsDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// ��Ȼ�̳߳���������Ҫ������  ThreadPoolExecutor ������ͨ������๹���̳߳�̫�鷳�ˣ�����ֻҪ��ʹ�ù�����
		// Executors �����̳߳ؾͺ��ˡ�
	
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
		
		
		// Executors.newCachedThreadPool() ---->  Դ��������ʵ��   corePoolSize Ϊ0�� maximumPoolSize Ϊ Integer.MAX_VALUE �� ThreadPoolExecutor
//		�������ǿ��ԷŽ��ǳ�����߳�Ŷ������
		// ��������������Ǽ������ã���Ϊ�ܿ��ܻ��ڴ治���� һ����˵�������� newFixdThreadPool()   ��������Ƚ϶ࡣ
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
