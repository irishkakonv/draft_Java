package NIIT;


@MyInterface(value = 1, str = "Hello!")
class MyClass1 {
	@MyInterField(field = "FIELD")
	private int val;

	@MyInterfaceConstr(constr = "This costructor")
	public MyClass1(int i){
		this.val = i;
	}
	
	@MyInterface2(str2 = "Method 1")
	public void setVal(int i) {
		val += i;
	}
	
	@MyInterface2(str2 = "Method 2")
	public int getVal() {
		return val;
	}
	
	public static void main(String[] args) {
		 MyClass1 m = new MyClass1(1);
		 m.setVal(1);
		 m.getVal();
	}	
}
