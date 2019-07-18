package lesson10多线程学习5_生产消费模式;

public class GetStudent implements Runnable {
	private Student s;

	public GetStudent(Student s) {
		this.s = s;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (s) {
				if(!s.getFlag()) {
					try {
						s.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println(s.getName() + "--" + s.getAge());
				s.setFlag(false);
				s.notify();
			}
		}
	}

}
