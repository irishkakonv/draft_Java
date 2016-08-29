package NIIT;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;;



public class Collection {

	public static void main(String[] args) {
		LinkedList<String> ls = new LinkedList<>();
		LinkedList<Integer> li = new LinkedList<>();
		
		ArrayList<String> as = new ArrayList<>();
		
		Iterator<String> strIter = ls.iterator();
		strIter.next();  
		
		/*Integer i = new Integer(1);  //автоупаковка
		int i2 = 1;
		*/
		
		
		ls.add("");
		li.add(123);
	}

}
