package lesson11�������ģʽ�˽�;

// ����ʽ����ģʽ
class Teacher{
	private Teacher() {};
	private static Teacher t = new Teacher();
	
	public static Teacher getTeacher() {
		return t;
	}
}

// ����ʽ����ģʽ
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
