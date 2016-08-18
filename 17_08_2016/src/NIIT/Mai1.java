package NIIT; //Exception

class Stack {
	private int top = 0;
	private int array[] = new int[10];

	public int pop() {
		int index = top - 1;
		if (index >= 0) {
			int tmp = array[index];
			top--;
			return tmp;
		} else {
			RuntimeException ex = new RuntimeException("Stack overflow");
			throw ex;
		}
	}

	public int push(int value) {
		if (top <= 9) {
			array[top] = value;
			top++;
			return 0;
		} else {
			RuntimeException ex = new RuntimeException("Stack overflow");
			throw ex;
		}
	}

}

public class Mai1 {

	public static void main(String[] args) {
		Stack st = new Stack();
		Stack st2 = new Stack();
		for (int i = 0; i < 10; i++) {
			System.err.println("push element # " + i);
			try {
				st.push(i);
			} catch (RuntimeException ex) {
				try {
					st2.push(i);
				} 
				catch (RuntimeException exInternal) {
					System.err.println("There are no Stacks anymore.");
				}
			} 
			finally {
				System.err.println("Push()");
			}
		}
		for (int i = 0; i < 11; i++) {
			int value;
			try {
				value = st.pop();
			} catch (RuntimeException exExternal) {
				try {
					value = st2.pop();
				} catch (RuntimeException exIxternal) {
					throw new RuntimeException("Stack 2 is empty");
				}
			}
			System.err.println("Get element # " + i + "=" + st.pop());
		}
	}
}
