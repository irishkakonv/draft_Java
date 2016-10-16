package NIIT;

class Data{
	private static int index = 0;
	
	private static Object monitorDbConnection = new Object();
	private static Object monitorConfigFire = new Object();
	
//	 synchronized public static void incr(){
	public static void incr(){
		System.out.println("start");
		synchronized (monitorDbConnection) {
			index++;
		}
		synchronized (monitorConfigFire) {
			index++;
		}
		System.out.println("end");
	}
	public static int getIndex(){
		return index;
	}
}

class MyRunnable implements Runnable{
	private volatile boolean needWork = false;
	
	public void stopWork() {
		needWork = false;
		
	}
	
	@Override
	public void run() {
		needWork = true;
		
		int n = 10000;
		
		for (int i = 0; i < n; i++){
			if(needWork){
				Data.incr();
			}
			else {
				System.out.println("STOPPED!______________________________________");
				break;
			}
		}
	}
}

public class Main26_3 {

	public static void main(String[] args) throws InterruptedException {
		
		MyRunnable r1= new MyRunnable();
		MyRunnable r2= new MyRunnable();
		MyRunnable r3= new MyRunnable();
		
//		Runnable l = () -> {
//			int n = 10000;
//		
//			for (int i = 0; i < n; i++){
//			Data.incr();
//			}
//		};
		
		long start = System.currentTimeMillis();
		
		Thread th1 = new Thread(r1);
		th1.start();
		
		
		Thread th2 = new Thread(r2);
		th2.start();
		
		Thread th3 = new Thread(r3);
		th3.start();
			
		th1.join(100);
		r1.stopWork();
		
		th2.join(70);
		r2.stopWork();
		
		th3.join();
		r3.stopWork();
		
		long end = System.currentTimeMillis();
		
		
		
		System.out.println("Data index " + Data.getIndex());
		System.out.println("Time ms " + (end - start));
	}

}
