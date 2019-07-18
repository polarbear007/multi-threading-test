package lesson10多线程学习6_生产消费模式3;

import java.util.Vector;

// 为了简单，我们这里只生产一种产品。就是包子

public class Test {
	public static void main(String[] args) {
		System.out.println("程序开始：");
		
		// 先创建一个集合，用来存放产品。因为要使用多线程，所以使用 Vector 集合，线程安全。
		Vector<Product> v = new Vector<Product>();

		// 创建一条线程用来生产包子
		Make m = new Make(v);
		Thread t1 = new Thread(m, "赵师傅");
		Thread t4 = new Thread(m, "刘师傅");

		// 创建2条线程用来卖包子
		Sell s = new Sell(v);
		Thread t2 = new Thread(s, "窗口1");
		Thread t3 = new Thread(s, "窗口2");
		
		//启动线程
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}
}
