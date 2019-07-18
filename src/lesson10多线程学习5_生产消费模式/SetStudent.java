package lesson10多线程学习5_生产消费模式;

public class SetStudent implements Runnable {
	private Student s;

	public SetStudent(Student s) {
		this.s = s;
	}

	@Override
	public void run() {
		int x = 0;
		while (true) {
			synchronized (s) {
				if (s.getFlag()) {
					try {
						s.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (x % 2 == 0) {
					s.setName("小明");
					s.setAge(10);
					s.setFlag(true);
				} else {
					s.setName("阿呆");
					s.setAge(5);
					s.setFlag(true);
				}
				x++;
				s.notify();
			}
		}

	}

}
