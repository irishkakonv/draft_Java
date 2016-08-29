package NIIT;

class Data{
	public static int index;
}

public class Main26_3 {

	public static void main(String[] args) throws InterruptedException {
		
		Runnable l = () -> {
			int n = 100000000;
		
			for (int i = 0; i < n; i++){
			Data.index++;
			}
		};
		
		Thread th1 = new Thread(l);
		th1.start();
		
		Thread th2 = new Thread(l);
		th2.start();
		
		Thread th3 = new Thread(l);
		th3.start();
			
		th1.join();
		th2.join();
		th3.join();

		System.out.println("Data index " + Data.index);
	}

}
