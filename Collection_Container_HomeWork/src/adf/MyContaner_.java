package adf;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

@FunctionalInterface
interface IInspect<T> {
	public T inspect(Student_<T> student);
}

@FunctionalInterface
interface ISet<T> {
	public void set(Student_<T> student);
}

@FunctionalInterface
interface IModif<T> {
	public void modif();
}


class Student_<T> {
	T name;

	public Student_(T string) {
		name = string;
	}
}

class Element<T> {
	Student_<T> student;
	ISet<T> set;
	IModif<T> modifodif;
	IInspect<T> inspect;
	
	public void setm() {
		set.set(student);
	}

	public void modifodifm() {
		modifodif.modif();
	}
	
	public void inspectm() {
		System.out.println(inspect.inspect(student));
	}
}

public class MyContaner_<T> {
	LinkedList<Element> list = new LinkedList<>();
	
	public static <T> void main(String[] args) {
		
		Element<String> element = new Element();
		element.student = new Student_("PETER");

		element.set = (Student_<String> st) ->{
			element.student.name = element.student.name + "is student!";
		};
		element.setm();

		
		element.modifodif = () -> {
			String str = element.student.name;
			char[] arr = str.toCharArray();
			for (int i = 1; i < arr.length; i = i + 2) {
				char a;
				a = arr[i - 1];
				arr[i - 1] = arr[i];
				arr[i] = a;
			}
			str = String.valueOf(arr);
			element.student.name = str;
		};
		element.modifodifm();

		element.inspect = (Student_<String> st) -> {
			return st.name;
		};
		element.inspectm();
		
		LinkedList<Object> list = new LinkedList<>();
		
		list.add(element);
		list.add(element.set);
		list.add(element.modifodif);
		list.add(element.inspect);
		
		System.out.println(list);
	}
}
