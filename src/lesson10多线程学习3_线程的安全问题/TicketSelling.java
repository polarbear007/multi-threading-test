package lesson10多线程学习3_线程的安全问题;

public class TicketSelling implements Runnable {
	private int count = 100;

	@Override
	public void run() {
		// 原来的代码，没有加同步代码块
//		while (count > 0) {
//			count--;
//			System.out.println(Thread.currentThread().getName() + ": 卖出一张票！ 现在还剩" + count + "张票！");
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}

		// 注意不要把while 也放到 synchronized 代码块里面，因为这样的话，会一个窗口卖完所有的票
//		synchronized (this) {
//			while (count > 0) {
//				count--;
//				System.out.println(Thread.currentThread().getName() + ": 卖出一张票！ 现在还剩" + count + "张票！");
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}

		// 应该把while 放到外面， 但是那个条件判断应该放到代码块里面
		while (true) {
			synchronized (this.getClass()) {
				if(count > 0) {
					count--;
					System.out.println(Thread.currentThread().getName() + ": 卖出一张票！ 现在还剩" + count + "张票！");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else {
					break;
				}
			}
		}
	}

}
