package NIIT;

import java.util.LinkedList;
import java.util.NoSuchElementException;

interface Stack_ {
	void push(int value);

	int pop();
}

class Element {
	private int number;

	Element(int number_) {
		this.number = number_;
	}

	public int getNumber() {
		return number;
	}
}

class Container_ implements Stack_ {
	LinkedList<Element> numbers = new LinkedList<Element>();

	@Override
	public void push(int value) {
		Element number = new Element(value);
		numbers.add(number);
	}

	@Override
	public int pop() {
		try {
			Element lastElement = numbers.getLast();
			numbers.removeLast();
			return lastElement.getNumber();
		} 
		catch (NoSuchElementException ex) {
			System.err.println("Stack is empty");
		}
		return 0;
	}
}

public class DinamicMemoryStack {
	public static void main(String[] args) {
		Container_ s = new Container_();
		s.push(2);
		s.push(5);
		s.push(7);
		s.push(9);
		System.out.println("The last element is " + s.pop());
		System.out.println("The last element is " + s.pop());
		System.out.println("The last element is " + s.pop());
		System.out.println("The last element is " + s.pop());
		System.out.println("The last element is " + s.pop());
	}
}
