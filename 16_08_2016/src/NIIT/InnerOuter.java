package NIIT;

class Outher{
	private int outerField;
	public void printOuter(){
		Inner i = new Inner();
		i.printInner();
		i.innerField = 10;
		System.out.println("Outer class");
	}
	public static class Inner{
		private int innerField = 0;
		public void printInner(){
			System.out.println("Inner class");
		}
	}
}


public class InnerOuter {
	public static void main(String[] args) {
		Outher outer = new Outher();
		outer.printOuter();
		Outher.Inner inner = new Outher.Inner(); 
	}

}
