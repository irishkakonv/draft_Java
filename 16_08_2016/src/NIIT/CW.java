package NIIT;
class Example{
	private int x = 0;
	
	public Example(int x){
		this.x = x;
	}
	public static void inspect(Example e){
		System.out.println("Example.x = " + e.x);
	}
	public void m(){
		System.out.println("Hello!");
	}
}
public class CW {
	public static void main(String[] args) {
		Example e = new Example(100);// or 
		//e.m();
		//new Example().m();// or ��� ������ 
		Example.inspect(e);//���������� � ������, �.�.���� ����� ����������� ������
		e.inspect(e);//�� ��������� �.� ����� static
		Example.inspect(new Example(123));//����� ��������� �� ���������� ������. ���������� ������ �� ����� ���������� ������ inspect
	
		
		

	}

}
