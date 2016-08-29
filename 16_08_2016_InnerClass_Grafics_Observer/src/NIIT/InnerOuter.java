package NIIT;

class Outher{
	private int outerField;
	public void printOuter(){
		Inner i = new Inner();
		i.printInner();
		i.innerField = 10;
		System.out.println("Outer class");
	}
	public void printOuter2() {
		System.out.println("Outer class from Inner Class");
	}
	
	
	
	public  class Inner{
		private int innerField = 0;
		public void printInner(){
			System.out.println("Inner class");
			Outher.this.printOuter2();
			System.out.println(outerField);
		}
	}
}


public class InnerOuter {
	public static void main(String[] args) {
		Outher outer = new Outher();
		outer.printOuter();
		//создание объектв внутреннего static класса 
//		Outher.Inner outerInner = new Outher.Inner();  
//		outerInner.printInner();
		
		//создание объекта внутреннего не static класса
		Outher.Inner oi = outer.new Inner();  
	}

}
