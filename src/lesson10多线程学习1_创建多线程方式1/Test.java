package lesson10多线程学习1_创建多线程方式1;

// 创建多线程的方法1：
/*
 *  	A:  创建一个 Thread 的子类(比如MyThread)，并重写 run() 方法
 *  	B:	创建 MyThread 的对象，需要几个线程就创建几个对象
 *  	C： 	通过对象调  start() 方法启动线程
 * 注意：   
 * 		虽然 run() 方法里面的存着多线程运行的代码，但是启动多线程，必须使用    start() 方法。
 * 			如果调用  run() 方法，只是普通的方法调用，没有多线程现象。
 * 
 */


public class Test {
	public static void main(String[] args) {
		MyThread mt1 = new MyThread();
		MyThread mt2 =  new MyThread();
		
		mt1.setName("小明");
		mt2.setName("阿呆");
		
		mt1.start();
		mt2.start();
	}
}
