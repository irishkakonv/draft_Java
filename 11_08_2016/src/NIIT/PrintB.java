package NIIT;

public class PrintB {
	public void printB(int a){
		int i = 0;
		int[] arr = new int[32];
			while (a != 0){
				arr[i] = a % 2;
				i++;
				a = a/2;
			}
		for(int j = arr.length-1; j >= 0; j--){
			System.out.print(arr[j]);
		}
	} 
}
