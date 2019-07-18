package lesson13���߳�ѧϰ����_volatile;

/**
 * �ڱ������У����ǵĹ�������� num, �ڲ�ͬ���߳��У�����������Ĳ������Ǽ򵥵ĸ�ֵ���������������ԭ���Եģ����ʱ������ʹ�� volatile ���η������þͻ�������ˡ�
 * 
 * ������ǲ����޸ķ��Ļ�����ô������ a�̸߳ո�ֵ num = 1, Ȼ���ж� num �Ƿ�Ϊ 0 ���������ȻҲ�ᷢ�������Ƿ����Ļ��ʲ����ߡ�
 * 		---- ע�⣺���﷢���Ļ��ʲ��߲�����˵num û���������̱߳��޸ġ�����Ҫ��ԭ���ǣ�����̶߳�����������޸ģ��Ա��߳��ǲ��ɼ��ġ�
 * 					ʵ���ϣ�����̺߳ܿ����Ѿ��� num �ĳ���0�� ���ǻ�û��ͬ�������ڴ���ȥ����
 * 
 * ������Ǽ��� volatile ���η��Ļ�����ô��ӡ��Ƶ�ʾʹ������ˡ�
 * 		----- ע�⣺ �����仯��ԭ�򲢲�����Ϊ volatile ���η������������ã����� b �̶߳� num �������޸ı�ÿɼ��ˡ� Ҳ����˵�� b �߳�һ�޸ģ� a �߳�������ܿ����ˡ�
 * 					����Ϊʲô����������ʱ�Ͳ������ˡ�
 * 
 * ------>    �������ֻҪ��סһ�㣺 volatile ���Ա�֤��ͬ�̼߳��޸ĵĿɼ��ԡ�   ����Ȼ���Ҳ�û�м��� volatile ��ʵ��Ӧ�����ӣ�
 */

class GetNum implements Runnable{
	private static volatile int num;
//	private static  int num;
	private boolean flag;
	public GetNum(boolean flag) {
		this.flag = flag;
	}
	@Override
	public void run() {
		while(true) {
			if(flag) {
				num = 1;
				if(num == 0) {
					System.out.println(Thread.currentThread().getName() + ": " + num);
				}
			}else {
				num = 0;
				
				if(num == 1) {
					System.out.println(Thread.currentThread().getName() + ": " + num);
				}
			}
		}
	}
}


public class VolatileTest01 {
	public static void main(String[] args) {
		new Thread(new GetNum(true), "true").start();
		new Thread(new GetNum(false), "false").start();
	}
}
