package adf;

import java.awt.Container;
import java.awt.Window.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//interface IAdd<T>{
//	public void add(T name, T str1, T str2, T str3); 
//}
//
//interface IInspect<T> {
//	public void inspect(T type);
//}
//
//interface ISet<T> {
//	public void set(T type);
//}
//
//interface IModif<T> {
//	public void modif(int index);
//}

class Student<T> {
	T name;
	
	public void add(T name, T str1, T str2, T str3) {}
	public void set(T type) {}
	public void modif(T type) {}
	public T inspect(T type) {
		return type;}
}

public class MyContaner<T> extends Student<T>{
	ArrayList<String> arr = new ArrayList<>();
	
	@Override
	public void add(T name, T str1, T str2, T str3) {
		arr.add((String) name);
		arr.add((String) str2);
		arr.add((String) str3);
		arr.add((String) str1);
	}
	
	@Override
	public void modif(T type) {
		String s = (String)type;
		System.out.println(s.toUpperCase());
	}

	@Override
	public T inspect(T type) {
		
		return type;
	}
	

	@Override
	public void set(T type) {
		System.out.println(arr);
	}

	


	public static <T> void main(String[] args) {
		Student<String> mc = new MyContaner<>();
		Student<String> mc1 = new MyContaner<>();
		mc.add("Petrov", "modif", "set", "inspect");
		mc.add("Ivanov", "modif", "set", "inspect");
		
		System.out.println(mc.inspect("Hello!"));
		mc.modif("Hello!");
		mc.set("Hello!");
		mc.inspect("Hello");
		

	}

}
