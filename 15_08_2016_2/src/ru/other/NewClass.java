package ru.other;

import NIIT.A;
import NIIT.B;
import NIIT.ClassWork1;

public class NewClass extends B {
	//public void m(char ch, int value){}                            // if m() not final можем переопределить
	public void m(){                                                 // if m()  final
		A a = new A();
		B b = new B();
		ClassWork1 m = new ClassWork1();
		
		//double a = PI;  //не можем обратиться к  final поле
		
		B b_ = new B();
		
		// полиморфизм - наследний явл. предком
		
		Object o = b_;
	}

}
