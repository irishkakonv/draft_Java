package NIIT;

public class classWork {
	public static boolean isPrime(int value){
		boolean isPrime = false;
		for(int i = 2; i < value; i++){
			if(value % i == 0){
				isPrime = false;
				break;
			}
			else{
				isPrime = true;
			}
		}	
		return isPrime;
	}	
		
	public static void main(String[] args) {
		int a = 8;
		System.out.println("The word is prime = " + isPrime(a));
	}
}	
