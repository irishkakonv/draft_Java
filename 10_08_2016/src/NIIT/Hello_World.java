package NIIT;

public class Hello_World {
	public static void printBinary(int value){
		//         0b00000000_00000000_00000000
		int mask = 0b10000000_00000000_00000000;
		//         0bX0000000_00000000_00000000
		char printChar;
	//	int rez = mask & value;
		System.out.print("Dec: " + value + " Binary.");
		for(int i = 0; i <= 31; i++){
			int newMask = mask >> i;
			int zerultValue = newMask & value; // 0 or not 0
			
		//	System.out.println("mask is: " + newMask);
		//	System.out.println("rezultValue is: " + zerultValue);
			
			if(zerultValue == 0){
				printChar = '0';
			}
			else{
				printChar = '1';
			}
			System.out.print(printChar);
			if(i == 7 || i == 15 || i == 23){
				System.out.print('_');
			}
		}
		System.out.print('\n');
	}

	public static void main(String[] args) {
		//int a = 0b11111111_11111111_11111111_11111111;
		//int a = 0b00000000_00000000_000000000_00000000;
		int a = 0b00000110_00000000_000000110_01000100;
		printBinary(a);

	}

}

