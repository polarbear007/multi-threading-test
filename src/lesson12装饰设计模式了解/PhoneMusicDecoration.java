package lesson12装饰设计模式了解;

public class PhoneMusicDecoration extends PhoneDecoration {
	private Phone p;
	public PhoneMusicDecoration(Phone p) {
		super(p);
		this.p = p;
	}

	@Override
	public void call() {
		p.call();
		System.out.println("这个手机具有听音乐的功能了!");
	}

}
