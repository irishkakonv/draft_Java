package NIIT;

public class Main1 {
	/*String s = "aaa" + "bbb";
	String s2 = "aaa".concat("bbb");  //���������� ����������. ����� �� ������������ ���������� ����������
*/
	public static void main(String[] args) {
		String line = new String();
		for(int i =0; i < 100; i++){
			line +=  "iteration" + i;
		}
		System.out.println("LINE: " + line);

	}

}
