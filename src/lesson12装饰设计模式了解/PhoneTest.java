package lesson12装饰设计模式了解;

/*	
 * 	注意：   其实这里装饰模式跟继承的作用是相似的。要给以前的类添加新的功能的话，创建新的子类也是可以实现的。
 * 			但是如果我们想要使用继承来写的话，那么我们就应该去创建 Iphone的三个子类来实现下面的需求。
 * 
 * 		而使用装饰模式的好处在于，装饰模式的扩展性比较好。 因为PhoneDecoration 类是面向 Phone 来写的，对于 其子类 Iphone 是适用的， 对于其其他（未知）的子类也同样适用。
 * 		如果我们使用继承来写的话，那么我们只能 是面向  Iphone 来写，Iphone 类要实现这些功能 ，写三个子类来实现 。
 * 									XiaoMi 类也想实现这三个功能 ，又得重新写三个子类来实现。
 * 									HuaWei 类也想实现这三个功能 ，又得重新写三个子类来实现。
 * 									......
 * 
 * 		使用装饰者模式的好处是显而易见的。但是缺点就是：   比较复杂，难以理解 ！！！！
 * 
 * 		装饰模式的应用实例：
 * 			IO流里面大量使用了装饰模式。   （嵌套来嵌套去的）
 * 				认真地说起来，IO流其实就只有一种：字节流。  其他的流都是使用装饰模式的包装流，为了添加一些特定功能而设定的。当然，IO流里面的包装要比我们的手机案例复杂得多。
 * 					这些包装类之间的嵌套关系是不能随便改变的！！！！
 * 			Scanner也是包装类哟！
 */ 

public class PhoneTest {
	public static void main(String[] args) {
		Phone p = new Iphone();
		p.call();
		System.out.println("----------------");
		
		// 想要在打电话之前添加彩铃的功能！！
		PhoneDecoration pd = new PhoneRingDecoration(p);
		pd.call();
		
		System.out.println("----------------");
		// 想要在打电话之后添加听音乐的功能！！
		pd = new PhoneMusicDecoration(p);
		pd.call();
		
		
		System.out.println("-----------------");
		//  想要同时添加彩铃和听音乐的功能 ！！！
		pd = new PhoneRingDecoration(new PhoneMusicDecoration(p));
		pd.call();
		
		
		// 因为这两个装饰类是平级的，所以谁前谁后没有关系。
		// 当然，我们也可以再写一个复合的装饰类，这个装饰类同时增加了彩铃和音乐的功能 。（但是没有必要）
		System.out.println("-----------------");
		//  想要同时添加彩铃和听音乐的功能 ！！！
		pd = new PhoneMusicDecoration(new PhoneRingDecoration(p));
		pd.call();
	}
}
