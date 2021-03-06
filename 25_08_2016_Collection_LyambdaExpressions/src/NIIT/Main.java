package NIIT;

//interface Action{
//	default void act(){System.out.println("Default act() impl");}
//	default void act1(){System.out.println("Default act1() impl");}
//	default void act2(){System.out.println("Default act2() impl");}
//	default void act3(){System.out.println("Default act3() impl");}
//	default void act4(){System.out.println("Default act4() impl");}
//}

interface ActionA{
	 void act();
	 void act1();
	 void act2();
	 void act3();
	 void act4();
}

abstract class ActionAdapter implements ActionA{
	 public void act(){System.out.println("Default act() impl");}
	 public void act1(){System.out.println("Default act1() impl");}
	 public void act2(){System.out.println("Default act2() impl");}
	 public void act3(){System.out.println("Default act3() impl");}
	 public void act4(){System.out.println("Default act4() impl");}
}

//class A implements Action{
//	@Override
//	public void act() {
//		System.out.println("class A act() impl");
//	}
//}
class Aa extends ActionAdapter{
	@Override
	public void act() {
		System.out.println("class A act() impl");
	}
}

public class Main {

	public static void main(String[] args) {
		Aa a = new Aa();
		a.act();

		
	}

}
