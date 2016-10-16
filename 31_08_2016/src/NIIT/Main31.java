package NIIT;

class A{
	public int a;
	public A(int a){
		this.a = a;
	}
	
}
public class Main31 {
	static A a = new A(10);

	public static void main(String[] args) throws InterruptedException {
		Thread th1 = new Thread(() ->{
			a.a++;
			System.out.println("th1 a = " + a.a);
		});
		th1.start();
		
		Thread th2 =  new Thread(() ->{
			a.a++;
			System.out.println("th2 a = " + a.a);
		});
		th2.start();
		
		th1.join();
		th2.join();
		
		System.out.println("Main a" + a.a);
	}

}
