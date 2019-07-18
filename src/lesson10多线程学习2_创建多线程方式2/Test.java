package lesson10多线程学习2_创建多线程方式2;
// 创建多线程的方式2：
/*		A：	创建一个Runnable 接口的实现类(MyRunnable)，并且重写run() 方法
 * 		B:	在测试类中，创建 MyRunnable对象 （只需要一个）
 * 		C:  创建Thread 类的对象，并把  MyRunnable对象作为参数传递给  Thread 对象（需要几个线程，就创建几个Thread对象）
 * 		D:	通过   start() 方法启动线程！
 * 
 * 思考：	为什么有了方式1，还要弄一个方式2呢？
 * 			因为方式1必须要继承Thread 类，可是有可能我们需要多线程运行的类，已经有父类了。JAVA是不允许有多继承的。
 * 				而且，方式2的设计实现了数据与多线程功能的有效分离，更符合面向对象的思想。
 */


public class Test {
	public static void main(String[] args) {
		MyRunnable mr = new MyRunnable();
		
		Thread t1 = new Thread(mr);
		Thread t2 = new Thread(mr);
		
		t1.setName("小明");
		t2.setName("阿呆");
		
		t1.start();
		t2.start();
	}
}
