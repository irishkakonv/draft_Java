package NIIT;

class Singlton{
	private String data;
	private static Singlton instance = null;
	
	public String getData(){
		return data;
	}
	
	public static Singlton getInstance(String data){
		if (instance == null){
			instance =  new Singlton(data);
		}
		return instance;
	}
	
	public void setData(String data){
		this.data = data;
	}
	
	private Singlton(String data) {
		this.data = data;
	}
}

public class Pattern {
	
	public static void main(String[] args) {
		Singlton s1 = Singlton.getInstance("First");
		Singlton s2 = Singlton.getInstance("Second");
		s2.setData("No DAta");
		System.out.println("s1 " + s1.getData());
		System.out.println("s2 " + s2.getData());
	}

}
