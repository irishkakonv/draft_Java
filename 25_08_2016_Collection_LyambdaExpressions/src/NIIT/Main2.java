package NIIT;

import javax.security.auth.kerberos.KerberosKey;

class Stack<Type extends Number>{
	private Number arr[] = new Number[10];
	private int top = 0;
	
	public void push(Type value){
		arr[top++] = value;
		
	}
	public Type pop(){
		return (Type)arr[top--];
	}
	
}
class Box<T>{
	private T data;
	public Box(T data){setData(data);}
	public T getData(){return data;}
	public void setData(T data){this.data = data;}
}

class Aclass{
	public <Key extends Number, Value extends Exception>void m(Key key, Value value) {
		Class k = key.getClass();
		Class v = value.getClass();
		System.out.println("Key: " + k + "Value " + v);
	}
}

public class Main2 {

	public static void main(String[] args) {
		Aclass a = new Aclass();
		a.m(1, new RuntimeException());
		
		
		Box b = new Box(13);
		System.out.println(b.getData());
		
		Box<String> sbBox = new Box<String>("line");
		
		sbBox.setData("aaa");
		String line =(String)sbBox.getData();
		System.out.println(line.charAt(1));
		
		
		Stack st = new Stack();
		st.push(1);
		st.push(2);
		st.push(3);
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
	}

}
