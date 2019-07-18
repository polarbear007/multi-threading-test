package lesson10多线程学习6_生产消费模式2;

public class Student {
	private String name;
	private int age;
	private boolean flag;

	public Student() {
		super();
	}

	public Student(String name, int age, boolean flag) {
		super();
		this.name = name;
		this.age = age;
		this.flag = flag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public synchronized void setStudent(int x) {
		if(flag == true) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if(x%2==0) {
			setName("张学友");
			setAge(20);
		}else {
			setName("林心如");
			setAge(30);
		}
		
		setFlag(true);
		this.notify();
	}
	
	public synchronized void getStudent() {
		if(flag == false) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(getName() + "--" + getAge());
		setFlag(false);
		this.notify();
	}

}
