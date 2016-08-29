package NIIT;

public class Strings {
	/*String s = "aaa" + "bbb";
	String s2 = "aaa".concat("bbb");  //перегрузка операторов. джава не поддерживает перегрузку операторов
*/
	public static void main(String[] args) {
		String line = new String();
//		StringBuilder sb = new StringBuilder(100);
		for(int i =0; i < 100; i++){
			line +=  "iteration" + i;
//			sb.append("iteration");
//			sb.append(i);
			System.out.println("LINE: " + line + i);
		}
		

	}

}
