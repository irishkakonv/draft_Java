package NIIT;

import java.lang.annotation.Annotation;
import java.util.Arrays;

class GetAnnClass {
	public void getAnnClass() throws ClassNotFoundException {
		System.out.println("Info about class");
		
		System.out.println("Annotation");
		
//		Class<?> c = Class.forName(nameClass);
		
		Class<?> c = Class.forName("NIIT.MyClass1");
		
		Annotation[] ans = c.getDeclaredAnnotations();
		for(Annotation a: ans){
			if(a instanceof MyInterface){
			MyInterface mi = (MyInterface) a;
			System.out.println(mi.str());
			System.out.println(mi.value());
			}
		}
		
		System.out.println(ans.getClass());
		System.out.println(Arrays.toString(ans));
		System.out.println("Length of ans " + ans.length);
		
		System.out.println("--------------------------------");
		
	}
}