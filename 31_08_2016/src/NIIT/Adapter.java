package NIIT;

interface IA{
	void m1();
	void m2();
	void m3();
	
}

interface IB{
	void f1();
}

class IAuser{
	public static void useIA_m1(IA ia) {
		ia.m1();
		
	}
	public static void useIA_m2(IA ia) {
		ia.m2();
		
	}
	public static void useIA_m3(IA ia) {
		ia.m3();
		
	}
}

class IAdapter implements IA{

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m3() {
		// TODO Auto-generated method stub
		
	}
}

public class Adapter {

	public static void main(String[] args) {
		IAuser.useIA_m2(new IAdapter() {
						
			@Override
			public void m2() {
				System.out.println("m2 implemantation");
			}
			
		});
		
		IAuser.useIA_m3(new IAdapter() {
			
			@Override
			public void m3() {
				System.out.println("m3 implemantation");
			}
			
		});
	}

}
