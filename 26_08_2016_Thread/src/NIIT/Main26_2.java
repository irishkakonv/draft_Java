package NIIT;

class Aa extends Thread{
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++){
			System.out.println(this.toString() + ":" + i);
		}
	}
}

class B implements Runnable{
	@Override
	public void run() {
		for(int i = 0; i < 1000; i++){
			System.out.println(this.toString() + ":" + i);
			}
	}
}


public class Main26_2 {

	public static void main(String[] args)  {
		Aa a = new Aa();
		a.start();
		
		B b = new B();
		Thread th1 = new Thread(b);
		th1.start();
		
		for(int i = 0; i < 100; i++){
			System.out.println("Main26_2" + ":" + i);
		}
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 100; i++){
					System.out.println(this.toString() + ":" + i);
					}
				}
			}
		).start();
		
		new Thread(() -> {System.out.println("sdf");}).start();
	
	
	
	}
}
