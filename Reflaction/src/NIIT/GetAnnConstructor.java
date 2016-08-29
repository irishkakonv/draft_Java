package NIIT;
//package NIIT;
//
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.util.Arrays;
//
//@Target(ElementType.CONSTRUCTOR)
//@Retention(RetentionPolicy.RUNTIME)
//@interface MyInterfaceConstr{
//	String constr();
//}
//
//
//class MyClass2{
//	private int val;
//	
//	@MyInterfaceConstr(constr = "This costructor")
//	public MyClass2(int i){
//		this.val = i;
//	}
//	
//	
//	public void setVal(int i) {
//		val += i;
//	}
//	
//	
//	public int getVal() {
//		return val;
//	}
//}
//

class GetAnnConstructor {
	public void gam() throws ClassNotFoundException {
		System.out.println("Info about constructor");
	
		System.out.println("Annotation");
		
		Class<?> c = Class.forName("NIIT.MyClass1");
		
		Constructor<?>[] ans = c.getDeclaredConstructors();
		for(Constructor<?> a: ans){
			System.out.println(Arrays.toString(a.getAnnotations()));
		}
		
		System.out.println(ans.getClass());
		System.out.println("The ans length is " + ans.length);
		
		System.out.println("-------------------------------");
	}
}
//
//
//public class ReturnAnnConstructor {
//
//	public static void main(String[] args) throws ClassNotFoundException  {
//		MyClass2 m = new MyClass2(1);
//		m.setVal(1);
//		m.getVal();
//		System.out.println("Annotation");
//		
//		GetConstrMeth gcm = new GetConstrMeth();
//		gcm.gam();
//				
//	}
//}
