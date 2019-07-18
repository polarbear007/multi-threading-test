package lesson11单例设计模式了解;

// 饿汉式单例模式
class Teacher{
	private Teacher() {};
	private static Teacher t = new Teacher();
	
	public static Teacher getTeacher() {
		return t;
	}
}

// 懒汉式单例模式
class Student {
	private Student() {};
	private static Student stu = null;
	
	public static synchronized Student getStudent() {
		if(stu == null) {
			stu = new Student();
		}
		return stu;
	}
}
public class Test {
	
}
