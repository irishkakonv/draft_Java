package NIIT;

import java.util.ArrayList;

interface Stack{
	void push(int value);
	int pop();
}

class Container implements Stack{
	ArrayList<Integer> arrL = new ArrayList<Integer>();
	@Override
	public void push(int value) {
		arrL.add(value);
	}
	@Override
	public int pop() {
		int s = arrL.size();
		return arrL.get(s-1);
	}
}

public class DinamicMemoryHomeWork {
	public static void main(String[] args) {
		Container s = new Container();
		s.push(2);
		s.push(5);
		s.push(7);
		System.out.println("The last element is " + s.pop());
		
	}

}
