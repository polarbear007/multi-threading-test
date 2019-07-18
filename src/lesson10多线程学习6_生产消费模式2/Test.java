package lesson10多线程学习6_生产消费模式2;

// 使用匿名内部类可以少创建两个类。
//  并且，同步代码块可以写在Student类里面。  只要多个线程修改的数据，被同一把锁锁住就行了。(当然，那样子写是不太好的。因为学生类里面包含同步方法，感觉就很奇怪)

public class Test {
	public static void main(String[] args) {
		Student s  = new Student();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				int x = 0;
				while(true) {
					s.setStudent(x);
					x++;
				}
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				while(true) {
					s.getStudent();
				}
			}
		};
		
		t1.start();
		t2.start();
	}
}
