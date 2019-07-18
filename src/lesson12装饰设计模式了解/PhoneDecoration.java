package lesson12装饰设计模式了解;

public abstract class PhoneDecoration implements Phone{
	private Phone p;

	public PhoneDecoration(Phone p) {
		this.p = p;
	}
	
	public void call() {
		p.call();
	}
}
