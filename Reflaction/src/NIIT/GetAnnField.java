package NIIT;

//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Arrays;
//
//
//@Target(ElementType.FIELD)
//@Retention(RetentionPolicy.RUNTIME)
//@interface MyInterField{
//	String field();
//}
//
//class MyClass3{
//	@MyInterField(field = "FIELD")
//	private int val;
//	
//	public MyClass3(int i){
//		this.val = i;
//	}
//	
//	public void setVal(int i) {
//		val += i;
//		
//	}
//	
//	public int getVal() {
//		System.out.println("Val = " + val);
//		return val;
//	
//	}
//	
//}
//
//	
class GetAnnField{
	public void gam() throws ClassNotFoundException {
		System.out.println("Info about field");
		
		System.out.println("Annotation");
		
		Class<?> c = Class.forName("NIIT.MyClass1");
		Field[] fields = c.getDeclaredFields();
		for(Field f: fields){
			System.out.println(Arrays.toString(f.getAnnotations()));
		}
		
		System.out.println("--------------------------------------");
	}
}
//
//public class ReturnAddField {
//
//	public static void main(String[] args) throws ClassNotFoundException  {
//		MyClass3 m = new MyClass3(1);
//		m.setVal(1);
//		m.getVal();
//		System.out.println("Annotation");
//		
//		GetAnnField g = new GetAnnField();
//		g.gam();
//		
//	}
//}
