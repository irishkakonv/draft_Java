package NIIT;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyInterface {
	int value();

	String str();
}

@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
@interface MyInterfaceConstr {
	String constr();
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyInterface2 {
	String str2();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyInterField {
	String field();
}

public class ReturnData {
	static ReturnData readClass = new ReturnData();
	static String nameClass = readClass.scanner();

	public String scanner() {
		System.out.println("Enter name class ");
		String s1 = null;
		Scanner sc = new Scanner(System.in);
		s1 = sc.nextLine();
		return s1;
	}

	public void getDataClass() throws ClassNotFoundException {
			System.out.println("Info about CLASS");
		
			Class<?> c = Class.forName(nameClass);
	
			Annotation[] ans = c.getDeclaredAnnotations();
			System.out.println("Class is \"" + ans.getClass() + "\"");
			System.out.println("Count of annotation to class is " + ans.length);
			System.out.println("Annotation: ");
			for (Annotation a : ans) {
				System.out.println(a);
				System.out.println("Type of annotation is \"" + a.annotationType() + "\"");
				System.out.println();
			}
			System.out.println("--------------------------------");
			System.out.println(" ");
		
	}

	public void getDataConstructor() throws ClassNotFoundException {
			System.out.println("Info about CONSTRUCTOR");
			Class<?> c = Class.forName(nameClass);
	
			Constructor<?>[] cons = c.getDeclaredConstructors();
	
			System.out.println("Count of constructor are " + cons.length);
			System.out.println("Annotation: ");
	
			for (Constructor<?> con : cons) {
				System.out.println(Arrays.toString(con.getDeclaredAnnotations()));
				System.out.println("Name of the constructor is \"" + con.getName() + "\"");
				System.out.println("The formal parameter types is \"" + Arrays.toString(con.getParameterTypes()) + "\"");
				System.out.println("Count of the parameters are " + con.getParameterCount());
				System.out.println("Name of class is \"" + con.getDeclaringClass() + "\"");
				System.out.println();
			}
			System.out.println("--------------------------------");
			System.out.println(" ");
		}

	public void getDataMeth() throws ClassNotFoundException {
			System.out.println("Info about METHOD");
	
			Class<?> c = Class.forName(nameClass);
	
			Method[] meths = c.getDeclaredMethods();
	
			System.out.println("Count of methods are " + meths.length);
			System.out.println("Annotation: ");
			for (Method meth : meths) {
				System.out.println(Arrays.toString(meth.getDeclaredAnnotations()));
				System.out.println("Name of the method is \"" + meth.getName() + "\"");
				System.out.println("The formal parameter types is \"" + Arrays.toString(meth.getParameterTypes()) + "\"");
				System.out.println("Count of the parameters are " + meth.getParameterCount());
				System.out.println("Name of class is \"" + meth.getDeclaringClass() + "\"");
				System.out.println();
			}
			System.out.println("--------------------------------");
			System.out.println(" ");
		
	}

	public void getDataField() throws ClassNotFoundException {
		
			System.out.println("Info about FIELD");
	
			Class<?> c = Class.forName(nameClass);
			Field[] fields = c.getDeclaredFields();
	
			System.out.println("Count of methods are " + fields.length);
			System.out.println("Annotation: ");
			for (Field field : fields) {
				System.out.println(Arrays.toString(field.getDeclaredAnnotations()));
				System.out.println("Name of the feild is \"" + field.getName() + "\"");
				System.out.println("Type of field is \"" + field.getType() + "\"");
				System.out.println("Name of class is \"" + field.getClass() + "\"");
				System.out.println();
			}
		
	}

	public static void main(String[] args) throws ClassNotFoundException {
		try{
			Class<?> c = Class.forName(nameClass);
			ReturnData getData = new ReturnData();
			// get info about class
			getData.getDataClass();
	
			// get info about constructor
			getData.getDataConstructor();
	
			// get info about method
			getData.getDataMeth();
	
			// get info about field
			getData.getDataField();
			return;
		}
		catch(Exception ex){
			System.err.println("!Class not find!");
		}
	}
}