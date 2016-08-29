package NIIT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {

	public static void main(String[] args) {
		String text[] = {"aaa", "abb", "bab", "aaa4", "bbb4"};
		String regEx = "^b.*";//        ^b.*  - begin b;   "^.*$"
 		Pattern pattern = Pattern.compile(regEx);	
		
		for(String line: text){
			System.out.println("__________");		
			System.out.println("line: " + line);
			Matcher matcher = pattern.matcher(line);
			if(matcher.find()){
				System.out.println("Found " + matcher.group());
				
			}
			else {
				System.out.println("not Found");
			}
		}
		
	}

}
