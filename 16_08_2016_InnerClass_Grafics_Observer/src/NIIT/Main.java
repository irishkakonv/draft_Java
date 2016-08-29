package NIIT;

/*class Example_ {

private int x = 0;

public Example_(int x) {
	this.x = x;
}

public static void inspect(Example e) {
	System.out.println("Example.x = " + e.x);
}

public void m() {
	System.out.println("Hello from exmaple class");
}
}*/

interface Progression {
	int next();
}

interface Storage {
	void save(int value);
	int get();
}

class A_ implements Progression, Storage {

	private int data;
	// private int seed = 1;

	@Override // Через этот метод будет расти прогрессия
	public int next() {
		data *= 2;
		return data;
	}

	@Override
	public void save(int value) {
		data = value;

	}

	@Override
	public int get() {
		return data;
	}
}

class B_ {
	public static void printNextValue(Progression p) {
		System.out.println("Next value is " + p.next());
	}
}

public class Main {
	public static void main(String[] args) {

		A_ a = new A_();

		Progression p = a;
		Storage s = a;

		s.save(4);
		System.out.println(a.get());
		// p.next();
		B_.printNextValue(p);

		// System.out.println(a.get());

		/*
		 * Example e = new Example(100); e.m();
		 * 
		 * new Example().m();
		 * 
		 * Example.inspect(e); Example.inspect(new Example(123));
		 */
	}

}
