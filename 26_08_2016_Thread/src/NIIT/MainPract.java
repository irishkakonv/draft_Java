package NIIT;

import java.util.ArrayList;

class MyThreadPool{
	private int size = 10;
	private ArrayList<Thread> threads = new ArrayList<>(size);
	
	public MyThreadPool(int size, String id){
		this.size = size;
	}
			
		
	public void execute(Runnable runnable, String id){
		Thread tmp = new Thread(runnable);
		tmp.setName(id);
		tmp.start();
		for (Thread thread : threads) {
			if(!thread.getName().equals(id)){
				threads.add(tmp);
			}
			else{
				System.out.println("Thread with this id is exist!");
			}
		}
	}
	
	public Thread getThread(String id) {
		Thread tmp = null;
		for (Thread thread : threads) {
			if (thread.getName().equals(id)){
				tmp = thread;
			}
		}
		return tmp;
	}
	
	
	public Thread.State getState(String id) {
		Thread.State tmp = null;
		for (Thread thread : threads) {
			if(thread.getName().equals(id)){
				tmp = thread.getState();
			}
		}
		return tmp;
	}
	
	public void pause(String id) throws InterruptedException {
		for (Thread thread : threads) {
			if(thread.getName().equals(id)){
				thread.wait();
			}
		}
	}
	
	public void kill(String id) {
		for (Thread thread : threads) {
			if(thread.getName().equals(id)){
				thread.suspend();
				
			}
		}
	}
	
}

public class MainPract {

	public static void main(String[] args) {
		

	}

}
