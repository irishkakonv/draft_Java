package NIIT;

interface Operator{
	int countUp(int op1, int op2);
}

class Calculator{
	private int op1;
	private int op2;
	private Operator operator;
	private int lastRezult;
	
	public Calculator(int o1, int o2, Operator operator){
		op1 = o1;
		op2 = o2;
		this.operator = operator;
	}
	
	public void setOperator(Operator sum) {
		this.operator = operator;
	}
	
	public int calculate() {
		return operator.countUp(op1, op2);
	}
	
	public int getLastRezult1() {
		return lastRezult;
		
	}
	public void setOp1(int op1) {
		this.op1 = op1;
	}
	
	public void setOp2(int op2) {
		this.op1 = op2;
	}
}

public class Stratergy {

	public static void main(String[] args) {
		Calculator calculator = new Calculator(5, 5, null);
		Operator sum = (int op1, int op2) -> {return op1 + op2;};
		Operator div = (int op1, int op2) -> {return op1/op2;};
		Operator mul = (int op1, int op2) -> {return op1*op2;};
		Operator sub = (int op1, int op2) -> {return op1-op2;};
		
		calculator.setOperator(sum);
		System.out.println("Sum = " + calculator.calculate());
		
		calculator.setOperator(div);
		System.out.println("div = " + calculator.calculate());
		
		calculator.setOperator(mul);
		System.out.println("mul = " + calculator.calculate());
		
		calculator.setOperator(sub);
		System.out.println("sub = " + calculator.calculate());
	}
}
