package lesson12װ�����ģʽ�˽�;

public abstract class PhoneDecoration implements Phone{
	private Phone p;

	public PhoneDecoration(Phone p) {
		this.p = p;
	}
	
	public void call() {
		p.call();
	}
}
