package lesson12װ�����ģʽ�˽�;

public class PhoneMusicDecoration extends PhoneDecoration {
	private Phone p;
	public PhoneMusicDecoration(Phone p) {
		super(p);
		this.p = p;
	}

	@Override
	public void call() {
		p.call();
		System.out.println("����ֻ����������ֵĹ�����!");
	}

}
