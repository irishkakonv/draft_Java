package NIIT;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@interface Date {
	int value();

	String text();
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface ClassDescr {
	String info();
}

@ClassDescr(info = "some information related to class A..")
@Date(value = 10, text = "cl A")

class A {

	@Date(value = 20, text = "field f")
	public int f;

	@Date(value = 30, text = "method test")
	public void test() {
		System.out.println("test(): f=" + f);
	}

	@Date(value = 40, text = "constructor A()")
	public A(int value) {
		f = value;
	}
}

public class Annotation_ {

	public static void main(String[] args) throws ClassNotFoundException {
		Class c = Class.forName("NIIT.A");
		Annotation_[] ans = (Annotation_[]) c.getAnnotations();

		for (Annotation_ a : ans) {
			System.out.println("Annotation ");
			if (a instanceof Date) {
				Date d = (Date) a;
				System.out.println("Text = " + d.text());
				System.out.println("value = " + d.value());
			}
			if (a instanceof ClassDescr) {
				ClassDescr d = (ClassDescr) a;
				System.out.println("Class info  is" + d.info());

			}
		}

	}

}
