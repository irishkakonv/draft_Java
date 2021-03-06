package NIIT;


@FunctionalInterface  //�������� ��� ������ �����������
interface Action{
	 String act(int i);
	 default void act2(){System.out.println("act2 impl");}
}


class A implements Action{
	@Override
	public String act(int i) {
		System.out.println("class A act() impl");
		return "as";
	}
}


public class LyambdaExpressions {

	static public int classf = 4;
	
	public static void main(String[] args) {
		
		final int local = 5;
		
		Action l0 = (int i)->{
			String line = "l1";
			line += classf;
			return line;
		};
		
		Action a = new A();
		a.act(local);
		handleAction(a);
		
//		handleAction(()->{
//			System.out.println("Anonim");
//		});
		
		Action l1 = (int value) ->{return "l1 act() impl";};
		Action l2 = (int value) ->{return "l2 act() impl";};
		Action l3 = (int value) ->{return "l3 act() impl";};
		
		for (int i = 0; i < 3; i++) {
			Action impl = null;
			if(i == 0){
				impl = l1;
			}
			else{
				if (i == 1) {
					impl = l2;
				}
				else {
					impl = l3;
				}
		}
		}

	}
	public static void handleAction(Action action) {
		System.out.println(action.act(42)); 
	}
}



