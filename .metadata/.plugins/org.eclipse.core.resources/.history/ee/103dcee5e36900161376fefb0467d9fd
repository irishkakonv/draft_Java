package NIIT;

//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;
//
//@Target(ElementType.METHOD)
//@Retention(RetentionPolicy.RUNTIME)
//@interface MyInterface2{
//	String str2();
//}
//
//
//class MyClass4{
//	
//	private int val;
//	
//	@MyInterfaceConstr(constr = "This costructor")
//	public MyClass4(int i){
//		this.val = i;
//	}
//	
//	@MyInterface2(str2 = "Method 1")
//	public void setVal(int i) {
//		val += i;
//	}
//	
//	@MyInterface2(str2 = "Method 2")
//	public int getVal() {
//		return val;
//	}
//}
//
//
class GetAnnMeth{
	public void gam() throws ClassNotFoundException {
		System.out.println("Info about method");
		
		System.out.println("Annotation");
		
		Class<?> c = Class.forName("NIIT.MyClass1");
		Method[] methods = c.getDeclaredMethods();
		for(Method nMethod: methods){
			System.out.println(Arrays.toString(nMethod.getAnnotations()));
		}
		
		System.out.println(methods.getClass());
		System.out.println("-------------------------------");
	}
}

//public class ReturnAnnMethod {
//
//	public static void main(String[] args) throws ClassNotFoundException  {
//		MyClass4 m = new MyClass4(1);
//		m.setVal(1);
//		System.out.println("Annotation");
//		
//		GetAnnMeth gam = new GetAnnMeth();
//		gam.gam();	
//		
//	}
//
//}
//
