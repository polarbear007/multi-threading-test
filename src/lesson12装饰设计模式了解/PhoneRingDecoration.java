package lesson12装饰设计模式了解;

public class PhoneRingDecoration extends PhoneDecoration {
	private Phone p;
	public PhoneRingDecoration(Phone p) {
		super(p);
		this.p = p;
	}

	@Override
	public void call() {
		System.out.println("电话具有彩铃功能了！");
		p.call();
	}

}
