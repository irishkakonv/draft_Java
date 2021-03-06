package NIIT;                                                //checked/unchecked error

class Stacks {
	private int top = 0;
	private int array[] = new int[10];

	public int pop() {

		int index = top - 1;
		if (index >= 0) {
			int tmp = array[index];
			top--;
			return tmp;
		} else {
			RuntimeException ex = new RuntimeException("Stacks overflow");
			throw ex;
		}
	}

	public int push(int value) {
		if (top <= 9) {
			array[top] = value;
			top++;
			return 0;
		} else {
			RuntimeException ex = new RuntimeException("Stacks overflow");
			throw ex;                                                      // ������ Exception
		}
	}

}

class MyThrowable extends Throwable {
	public String getInfo() {
		return "Something wrong!";
	}
}

class DemoExceptions {
	public void m1() throws MyThrowable {					//������������� � ��������� ������� ������
		System.out.println("m1() start");
		MyThrowable mt = new MyThrowable();
		if (true) {
			throw mt;
		}
		System.out.println("m1() end");
	}

	public void m2() throws MyThrowable {
		System.out.println("m2() start");
		try {
			m1();
		} 
		catch (MyThrowable th) {
			System.out.println("error");
		}
		System.out.println("m2() end");
		m1();
	}

	public void m3() throws MyThrowable { // �������������� �� Exception
		System.out.println("m3() start");
		System.out.println("m3() end");
		m2();
	}
}

public class Exception {
	public static void main(String[] args) {
		DemoExceptions de = new DemoExceptions();
		try {
			de.m3();
		} catch (MyThrowable th) {
			System.out.println("error" + th.getInfo());
		}
	}
}
