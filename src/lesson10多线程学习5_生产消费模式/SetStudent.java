package lesson10���߳�ѧϰ5_��������ģʽ;

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
					s.setName("С��");
					s.setAge(10);
					s.setFlag(true);
				} else {
					s.setName("����");
					s.setAge(5);
					s.setFlag(true);
				}
				x++;
				s.notify();
			}
		}

	}

}
