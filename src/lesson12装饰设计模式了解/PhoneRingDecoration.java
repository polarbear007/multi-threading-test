package lesson12װ�����ģʽ�˽�;

public class PhoneRingDecoration extends PhoneDecoration {
	private Phone p;
	public PhoneRingDecoration(Phone p) {
		super(p);
		this.p = p;
	}

	@Override
	public void call() {
		System.out.println("�绰���в��幦���ˣ�");
		p.call();
	}

}
